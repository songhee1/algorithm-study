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

public class BOJ_4963 {
    static int arr[][];
    static boolean visited[][];
    static int count;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> queue;
    static int dirX[] = { 1, 0, -1, 0, -1, 1, 1, -1 };
    static int dirY[] = { 0, 1, 0, -1, 1, 1, -1, -1 };
    static int w, h;

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            queue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == false) {
                        visited[i][j] = true;
                        queue.add(new Pair(i, j));
                        bfs();
                    }
                }
            }

            sb.append(count).append("\n");
            count=0;
        }
        System.out.println(sb);

    }

    static void bfs() {
        count++;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int dir = 0; dir < dirX.length; dir++) {
                int nx = pair.x + dirX[dir];
                int ny = pair.y + dirY[dir];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;
                if (visited[nx][ny] == false && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }
}
