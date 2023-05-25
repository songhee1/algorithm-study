package 그리디;

import java.io.*;
import java.util.*;

public class BOJ_15411 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st, sa;
    static int sum, total = 6;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            sa = new StringTokenizer(st.nextToken(), "+");
            sum = 0;
            while (sa.hasMoreTokens()) {
                sum += Integer.parseInt(sa.nextToken());
            }

            if (total == 6) {
                total = sum;
            } else {
                total -= sum;
            }
        }

        System.out.println(total);
    }
}
