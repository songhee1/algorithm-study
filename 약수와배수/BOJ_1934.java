package 약수와배수;

import java.io.*;
import java.util.*;

public class BOJ_1934 {
    static int n;
    static int a, b, result = 1;
    static boolean check;
    /*
     * [틀린 문제]
     * 2부터 a,b 중 큰 수까지 반복하여 나누어떨어지는 수는 찾고 최소공배수를 리턴한다
     * a,b가 1이면 1이 출력되게, 서로 같은 수면 a가 출력되게 하고자 하였다.
     * 
     * [유클리드 호제법 이용]
     * 시간 :148ms
     * gcb메서드로 최대공약수 구하고, a*b에서 최대공약수로 나누어 주어최대공배수를 구하였다.
     * 
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(a * b / gcb(a, b)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int gcb(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
            return gcb(a, b);
        }
        return a;
    }
}
