package BFS;

import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_7576 {
    static int arr[][];
    static boolean visited[][];
    static int distance[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> queue = new LinkedList<>();
    static int m, n;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static boolean flag;
    static int maxD;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];
        distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }

        dfs();

        if (flag == true) {
            System.out.println(-1);
        } else {
            System.out.println(maxD);
        }
    }

    static void dfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = pair.x + dirX[i];
                int nowY = pair.y + dirY[i];

                if (nowX < 0 || nowX >= m || nowY < 0 || nowY >= n)
                    continue;
                if (arr[nowX][nowY] == -1) {
                    flag = true; // 익지못하는 상황
                    continue;
                }
                if (arr[nowX][nowY] == 0 && visited[nowX][nowY] == false) {
                    visited[nowX][nowY] = true;
                    queue.add(new Pair(nowX, nowY));
                    


                    
                    distance[nowX][nowY] = distance[pair.x][pair.y] + 1;
                }
                if (maxD < distance[nowX][nowY]) {
                    maxD = distance[nowX][nowY];
                }
            }
        }
    }
}
