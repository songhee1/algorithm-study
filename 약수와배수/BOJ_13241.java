package 약수와배수;

import java.io.*;
import java.util.*;

public class BOJ_13241 {
    static long a, b;

    /*
     * 시간 : 132ms
     * 유클리드 호제법 이용
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        sb.append(a * b / gcb(a, b));
        System.out.print(sb);
        br.close();
    }

    static long gcb(long a, long b) {
        if (b == 0)
            return a;
        return gcb(b, a % b);
    }
}
