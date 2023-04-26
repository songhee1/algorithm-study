package 약수와배수;

import java.util.*;
import java.io.*;

public class BOJ_4134 {
    static long n, num;
    static boolean check = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            long r = num;
            if (num == 0 || num == 1 || num == 2) {
                sb.append(2).append("\n");
            } else {
                while (true) {
                    if (is_prime(r) == 1) {
                        sb.append(r).append("\n");
                        break;
                    }
                    r += 1;
                }
            }
        }

        System.out.print(sb);
        br.close();
    }

    static int is_prime(long r) {
        for (long j = 2; j <= Math.sqrt(r)+1; j++) {
            if (r % j == 0) {
                return -1;
            }
        }
        return 1;
    }
}
