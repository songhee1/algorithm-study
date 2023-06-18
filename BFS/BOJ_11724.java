package BFS;

import java.io.*;
import java.util.*;

public class BOJ_11724 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int u, v;
    static boolean visited[];
    static int count;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    static void dfs(int n) {
        for (int i = 0; i < arr[n].size(); i++) {
            int a = arr[n].get(i);
            if (visited[a] == false) {
                visited[a] = true;
                dfs(a);
            }
        }
    }
}
