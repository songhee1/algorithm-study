package 백트랙킹;

import java.io.*;
import java.util.*;

public class BOJ_15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean visit[];
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int v) {
        if (v == m) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
            dfs(v + 1);
            visit[i] = false;
            list.remove(v);
        }

    }
}
