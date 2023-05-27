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

public class BOJ_2178 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int arr[][];
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static int count = 0;
    static int distance[][];
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) s.charAt(j) - 48;
            }
        }

        queue.add(new Pair(0, 0));
        distance[0][0] = 1;

        bfs();

        System.out.println(distance[n - 1][m - 1]);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int dirA;
            int dirB;
            for (int i = 0; i < 4; i++) {
                dirA = dirX[i] + pair.x;
                dirB = dirY[i] + pair.y;

                if (dirA < 0 || dirA >= n || dirB < 0 || dirB >= m)
                    continue;
                if (arr[dirA][dirB] == 1 && distance[dirA][dirB] == 0) {
                    distance[dirA][dirB] = distance[pair.x][pair.y] + 1;
                    if (dirA == n - 1 && dirB == m - 1) {
                        return;
                    }
                    queue.add(new Pair(dirA, dirB));
                }

            }
        }
    }
}
