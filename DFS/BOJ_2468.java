package DFS;

import java.io.*;
import java.util.*;

/**
 * 안전 영역 최대 개수를 계산하는 프로그램
 * 입력 : n(행과 열의 갯수), 2차원정보
 */
public class BOJ_2468 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxNum = 0;
        for (int i = 0; i <= 100; i++) {
            visit = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visit[j][k] == false && arr[j][k] > i) {
                        visit[j][k] = true;
                        DFS(j, k, i);
                        count++;
                    }
                }
            }

            maxNum = Math.max(count, maxNum);
        }
        System.out.println(maxNum);
    }

    static void DFS(int x, int y, int depth) {
        visit[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dirX[dir];
            int ny = y + dirY[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            if (visit[nx][ny] == false && arr[nx][ny] > depth) {
                DFS(nx,ny,depth);
            }
        }
    }
}