package BFS;

import java.io.*;
import java.util.*;

public class BOJ_1697new {
    static int arr[];
    static boolean visited[];
    static int distance[];
    static int n, k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> queue = new LinkedList<>();
    static int MAX = 100005;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[MAX];
        visited = new boolean[MAX];
        distance = new int[MAX];

        queue.add(n);
        visited[n] = true;
        distance[n] = 0;

        System.out.println(dfs());
    }

    private static int dfs() {
        while (!queue.isEmpty()) {
            int posi = queue.poll();

            int n1 = posi - 1;
            int n2 = posi + 1;
            int n3 = posi * 2;

            if ((n1 >= 0 || n1 <= 100000) && visited[n1] == false) {
                visited[n1] = true;
                queue.add(n1);
                distance[n1] = distance[posi] + 1;

                if (n1 == k)
                    return distance[n1];
            }
            if ((n2 >= 0 || n2 <= 100000) && visited[n2] == false) {
                visited[n2] = true;
                queue.add(n2);
                distance[n2] = distance[posi] + 1;

                if (n2 == k)
                    return distance[n2];
            }
            if ((n3 >= 0 || n3 <= 100000) && visited[n3] == false) {
                visited[n3] = true;
                queue.add(n3);
                distance[n3] = distance[posi] + 1;

                if (n3 == k)
                    return distance[n3];
            }

        }
        return 0;
    }
}
