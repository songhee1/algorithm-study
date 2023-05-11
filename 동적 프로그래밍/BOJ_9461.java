import java.io.*;
import java.util.*;

public class BOJ_9461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long p[];
    static int testcase, n;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        p = new long[1000005];

        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;
        p[6] = 3;
        p[7] = 4;
        p[8] = 5;

        while (testcase-- > 0) {
            n = Integer.parseInt(br.readLine());

            for (int i = 9; i <= n; i++) {
                if (p[i] == 0) {
                    p[i] = p[i - 1] + p[i - 5];
                } else
                    continue;
            }
            sb.append(p[n]).append("\n");
        }
        System.out.print(sb);
        br.close();

    }
}
