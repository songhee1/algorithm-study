package BFS;

import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    Pair() {

    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_1926 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int arr[][];
    static int maxNum, count, findPicures;
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static boolean isVisited[][];
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisited[i][j] == false && arr[i][j] == 1) {
                    isVisited[i][j]=true;
                    queue.add(new Pair(i, j));
                    dfs();
                }
            }
        }

        System.out.println(findPicures);
        System.out.println(maxNum);

    }

    static void dfs() {
        findPicures++;
        count = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int dirA = dirX[i] + pair.x;
                    int dirB = dirY[i] + pair.y;
                    if(dirA<0 || dirA == n || dirB<0 || dirB==m) continue;
                    if (arr[dirA][dirB] == 1 && isVisited[dirA][dirB] == false) {
                        isVisited[dirA][dirB] = true;
                        queue.add(new Pair(dirA, dirB));
                        count++;
                    }
                }
            }

        }
        maxNum = Math.max(count, maxNum);
    }

}
