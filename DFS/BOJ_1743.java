package DFS;

import java.io.*;
import java.util.*;

/**
 * 제일 큰 음식물만 선생님이 피해가려고 한다. 큰 음식물 크기를 구하기
 * 
 * 입력 세로길이 n, 가로 길이 m, 음식물 쓰레기 개수 k
 */
public class BOJ_1743 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char arr[][];
    static boolean visit[][];
    static int n, m, k, count;
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = '.';
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = '#';
        }

        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '#' && visit[i][j] == false) {
                    count = 0;
                    DFS(i, j);
                    maxNum = Math.max(count, maxNum);
                }
            }
        }

        System.out.println(maxNum);
    }

    static void DFS(int i, int j) {
        count++;
        visit[i][j] = true;
        // System.out.println(count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dirX[dir];
            int ny = j + dirY[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue; 
            if (visit[nx][ny] == false && arr[nx][ny] == '#') {
                // System.out.println(nx+", "+ny);
                DFS(nx, ny);
            }
        }
    }
}
