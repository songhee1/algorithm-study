package 백트랙킹;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int n, m;
    static List<Integer>list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        backtracking(0, 1);

        System.out.println(sb);
    }

    static void backtracking(int count, int num) {
        if (count == m) {
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(i);
                backtracking(count + 1, i);
                visited[i] = false;
                list.remove(count);
            }
        }
    }
}
