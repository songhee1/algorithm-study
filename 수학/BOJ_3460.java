package 수학;

import java.util.*;
import java.io.*;

public class BOJ_3460 {
    static int t, n;
    static int rest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            String makeTwo = "";
            while (n != 0) {
                makeTwo += n % 2;
                n = n / 2;
            }
            for (int j = 0; j < makeTwo.length(); j++) {
                if (makeTwo.charAt(j) == '1')
                    sb.append(j).append(' ');
            }
        }
        System.out.print(sb);
        br.close();
    }
}
