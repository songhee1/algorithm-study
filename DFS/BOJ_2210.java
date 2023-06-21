package DFS;

import java.io.*;
import java.util.*;

/**
 * 방문여부 따지지 않고 모두 bfs 돌리고 돌릴때마다 list에 넣고 최대크기
 */
public class BOJ_2210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][];
    static StringTokenizer st;
    static ArrayList<String> list = new ArrayList<>();
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = Integer.toString(arr[i][j]);
                dfs(i, j, s);
            }
        }
        System.out.println(list.size());

    }

    static void dfs(int i, int j, String s) {
        if (s.length() == 6) {
            boolean flag = false;
            for (String string : list) {
                if (string.equals(s)) {
                    flag = true; // 같은게 있음!
                }
            }
            if (flag == false)
                list.add(s);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dirX[dir];
            int ny = j + dirY[dir];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                continue;
            dfs(nx, ny, s + (Integer.toString(arr[nx][ny])));
        }
    }
}
