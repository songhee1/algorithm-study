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

public class BOJ_4179 {
    static int r, c;
    static char arr[][];
    static boolean visited[][];
    static boolean jivisit[][];
    static int dist[][];
    static int jidist[][];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> queue;
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];
        dist = new int[r][c];
        jidist = new int[r][c];
        jivisit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String miro = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = miro.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dist[i][j] = -1;
            }
        }

        queue = new LinkedList();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'F') {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                    dist[i][j] = 0;
                    bfs();
                }
            }
        }

        queue.clear();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dist[i][j] == -1) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int content = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'J') {
                    jivisit[i][j] = true;
                    queue.add(new Pair(i, j));
                    content = jibfs();
                }
            }
        }
        if (content == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(content);
        }

    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int dir = 0; dir < dirX.length; dir++) {
                int nx = pair.x + dirX[dir];
                int ny = pair.y + dirY[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                    continue;

                if (visited[nx][ny] == false && arr[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[pair.x][pair.y] + 1;
                    queue.add(new Pair(nx, ny));
                }

            }
        }
    }

    static int jibfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int dir = 0; dir < dirX.length; dir++) {
                int nx = pair.x + dirX[dir];
                int ny = pair.y + dirY[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                    return jidist[pair.x][pair.y] + 1;

                if (jivisit[nx][ny] == false && arr[nx][ny] != '#' && (jidist[pair.x][pair.y] + 1 < dist[nx][ny])) {
                    jivisit[nx][ny] = true;
                    jidist[nx][ny] = jidist[pair.x][pair.y] + 1;
                    queue.add(new Pair(nx, ny));
                }

            }
        }
        return 0;
    }
}
