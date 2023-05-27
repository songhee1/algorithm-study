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

public class BOJ_1012 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m, n, k; // 가로, 세로, 배추 갯수
    static int arr[][];
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };
    static int count = 0;
    static boolean isvisited[][];
    static Queue<Pair> onequeue = new LinkedList<>();
    static int testcase;

    public static void main(String[] args) throws Exception {
        

        testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            count=0;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            isvisited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y]=1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1 && isvisited[i][j] == false) {
                        onequeue.add(new Pair(i, j));
                        isvisited[i][j] = true;
                        bfs();
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    static void bfs() {
        
        while (!onequeue.isEmpty()) {
            Pair pair = onequeue.poll();
            int dirA;
            int dirB;
            for (int i = 0; i < 4; i++) {
                dirA = dirX[i] + pair.x;
                dirB = dirY[i] + pair.y;
                if (dirA < 0 || dirA >= m || dirB < 0 || dirB >= n)
                    continue;
                if (arr[dirA][dirB] == 1 && isvisited[dirA][dirB] == false) {
                    isvisited[dirA][dirB] = true;
                    onequeue.add(new Pair(dirA, dirB));
                }
            }
        }
    }
}
