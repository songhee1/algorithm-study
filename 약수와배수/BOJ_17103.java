package 약수와배수;

import java.util.*;
import java.io.*;

public class BOJ_17103 {
    static int n, num;
    static int a, b;
    static int count;
    static boolean prime[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());

            prime = new boolean[num + 1];
            prime[0] = true;
            prime[1] = true;

            if (num == 2) {
                sb.append(0).append("\n");
                continue;
            }

            count = 0;
            is_prime();

            for (int j = 2; j <= num / 2; j++) {
                a = j;
                b = num - a;
                if (prime[a] == false && prime[b] == false)
                    count++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void is_prime() {
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (prime[i])
                continue;
            for (int j = i * 2; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
