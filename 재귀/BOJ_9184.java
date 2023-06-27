import java.io.*;
import java.util.*;

public class BOJ_9184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int a, b, c;
    static int dp[][][] = new int[21][21][21];

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            int n = 0;
            n += find(a, b, c);
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(n).append('\n');

        }
        System.out.println(sb);
    }

    static int find(int ai, int bi, int ci) {
        if (inRange(ai, bi, ci) && dp[ai][bi][ci] != 0) {
            return dp[ai][bi][ci];
        }

        if (ai <= 0 || bi <= 0 || ci <= 0) {
            return 1;
        }

        if (ai > 20 || bi > 20 || ci > 20) {
            return dp[20][20][20] = find(20, 20, 20);
        }
        if (ai < bi && bi < ci) {
            return dp[ai][bi][ci] = find(ai, bi, ci - 1) + find(ai, bi - 1, ci - 1) - find(ai, bi - 1, ci);
        }
        return dp[ai][bi][ci] = find(ai - 1, bi, ci) + find(ai - 1, bi - 1, ci) + find(ai - 1, bi, ci - 1)
                - find(ai - 1, bi - 1, ci - 1);

    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && 20 >= a && 0 <= b && 20 >= b && 0 <= c && 20 >= c;
    }
}
