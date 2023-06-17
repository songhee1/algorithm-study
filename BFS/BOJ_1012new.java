package BFS;

import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_1012new {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static Queue<Pair> queue = new LinkedList<>();
    static int textcase, m, n, k;
    static int arr[][];
    static boolean visited[][];
    static int a, b, count;

    public static void main(String[] args) throws Exception {
        textcase = Integer.parseInt(br.readLine());

        while (textcase-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            visited = new boolean[m][n];

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == false) {
                        visited[i][j] = true;
                        queue.add(new Pair(i, j));
                        dfs();
                    }
                }
            }

            sb.append(count).append("\n");
            count = 0;
        }

        System.out.println(sb);

    }

    private static void dfs() {
        count++;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = pair.x + dirX[dir];
                int ny = pair.y + dirY[dir];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny] == false && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }
}
