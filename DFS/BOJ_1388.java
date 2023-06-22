package DFS;

import java.io.*;
import java.util.*;

/**
 * 필요한 나무 판자의 갯수를 출력하는 문제
 */
public class BOJ_1388 {
    static int dshidirX[] = { 0, 0 };
    static int dshidirY[] = { 1, -1 };
    static int linedirX[] = { 1, -1 };
    static int linedirY[] = { 0, 0 };
    static char arr[][];
    static boolean visit[][];
    static int n, m, dshiN, lineN;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
                if (visit[i][j] == false) {
                    if (arr[i][j] == '-') {

                        dshidfs(i, j);
                        dshiN++;
                    } else if (arr[i][j] == '|') {

                        linedfs(i, j);
                        lineN++;
                    }
                }
            }
        }

        System.out.println(dshiN + lineN);

    }

    static void dshidfs(int i, int j) {
        visit[i][j] = true;

        for (int h = 0; h < 2; h++) {
            int nx = i + dshidirX[h];
            int ny = j + dshidirY[h];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (visit[nx][ny] == false && arr[nx][ny] == '-') {
                dshidfs(nx, ny);
            }
        }
    }

    static void linedfs(int i, int j) {
        visit[i][j] = true;

        for (int h = 0; h < 2; h++) {
            int nx = i + linedirX[h];
            int ny = j + linedirY[h];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (visit[nx][ny] == false && arr[nx][ny] == '|') {
                linedfs(nx, ny);
            }
        }
    }
}
