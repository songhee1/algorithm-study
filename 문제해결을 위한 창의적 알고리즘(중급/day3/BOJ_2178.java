package day3;

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

    static int arr[][];
    static int N, M;
    static int dist[][];
    static int NowX, NowY;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numS = br.readLine();
        String[] numArrynumS = numS.split("\\s");
        N = Integer.parseInt(numArrynumS[0]);
        M = Integer.parseInt(numArrynumS[1]);

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        bw.append(BFS(0, 0) + "\n");
        br.close();
        bw.close();

    }

    static int BFS(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        dist[i][j] = 1;
        queue.add(new Pair(i, j));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                NowX = cur.x + dx[dir];
                NowY = cur.y + dy[dir];
                if (CheckRange() && arr[NowX][NowY] == 1 && dist[NowX][NowY] == 0) {
                    queue.add(new Pair(NowX, NowY));
                    dist[NowX][NowY] = dist[cur.x][cur.y] + 1;
                }
            }
        }
        return dist[N - 1][M - 1];
    }

    static boolean CheckRange() {
        if (NowX < 0 || NowX >= N || NowY < 0 || NowY >= M)
            return false;
        return true;
    }
}
