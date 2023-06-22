package DFS;

import java.io.*;
import java.util.*;

/**
 * O: 빈공간/X:벽/I:도연이/P:사람 -> 도연이가 만날 수 있는 사람의 수 출력
 * 아무도 만나지 못한 경우 TT를 출력
 */

public class BOJ_21736 {
    static char arr[][];
    static boolean visit[][];
    static int n, m;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'I')
                    DFS(i, j);
            }
        }

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    static void DFS(int i, int j) {
        visit[i][j] = true;
        if (arr[i][j] == 'P') {
            count++;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dirX[dir];
            int ny = j + dirY[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (visit[nx][ny] == false && arr[nx][ny] != 'X') {
                DFS(nx, ny);
            }
        }
    }
}
