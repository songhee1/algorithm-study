package 수학;

import java.util.*;
import java.io.*;

public class BOJ_24313 {
    static int a1, a0, c, n0;
    static long sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split("\\s");
        a1 = Integer.parseInt(s[0]);
        a0 = Integer.parseInt(s[1]);
        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());
        /*
         * 조건 1. f(n)=a1*n+a0 이면서 
         * 조건 2.f(n)<=c*g(n) 인 양의 상수 c, n0가 존재하는 것을 보인다.
         * 위 조건을 만족시키지만, a1이 g(n)의 기울기보다 크다면, 반례가 존재한다.
         * 따라서, 조건1, 2를 만족하면서 a1이 g(n) 기울기 c*n0보다 큰 것만 1 출력
         *  
        */
        if (((a1 * n0 + a0) <= c * n0) && a1<=c)
            bw.append(1 + "");
        else
            bw.append(0 + "");
        bw.close();
        br.close();
    }
}
