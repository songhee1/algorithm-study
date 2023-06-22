package DFS;

import java.io.*;
import java.util.*;

/**
 * 검은색(1) : 전류를 차단하는 물질
 * 흰 색(0) : 전류가 통하는 물질
 * 전류는 가장 바깥쪽 흰색 격자들에 공급되고 이후 상하좌우 인접한 흰색 격자들로 전달
 * 안쪽까지 침투될 수 있는지 판단하는 프로그램 작성
 */
public class BOJ_13565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean visit[][];
    static int arr[][];
    static int m, n;// m개의 줄을 거쳐
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static boolean flag;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0 && visit[0][j] == false) {
                DFS(0, j);
                if (flag == true) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");

    }

    static void DFS(int i, int j) {
        visit[i][j] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dirX[dir];
            int ny = j + dirY[dir];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (visit[nx][ny] == false && arr[i][j] == 0) {
                DFS(nx, ny);
            }
        }

        if (i == m - 1) {
            flag = true;

        }

    }
}