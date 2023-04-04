package 수학;

import java.util.*;
import java.io.*;

public class BOJ_17427 {
    static int n, sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int subsum = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    if (j * j == i) {
                        subsum += j;
                    } else {
                        subsum += j;
                        subsum += i / j;
                    }

                }
            }
            sum += subsum;
        }
        bw.append(sum + "");
        br.close();
        bw.close();
    }
}
