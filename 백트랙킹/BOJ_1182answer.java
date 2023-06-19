package 백트랙킹;

import java.io.*;
import java.util.*;

public class BOJ_1182answer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, s, nums;
    static int arr[];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (s == 0) {
            nums--;
            System.out.println(nums);
        } else {
            System.out.println(nums);
        }

    }

    static void dfs(int v, int sum) {
        if (v == n) {
            if (sum == s) {
                nums++;
            }
            return;
        }

        dfs(v + 1, sum + arr[v]);
        dfs(v + 1, sum);
    }
}
