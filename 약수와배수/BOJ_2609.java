package 약수와배수;

import java.io.*;
import java.util.*;

public class BOJ_2609 {
    static int a, b;
    static int bignum, smallnum;
    /*
     * 유클리드 호제법 이용(그 중 재귀법, 반복문)
     * GCD(a,b)= GCD(b, a%b)= ... =GCD(p,0)= p
     * 
     * 시간 : 128ms
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bignum = gcb(a, b);
        sb.append(bignum).append("\n");
        sb.append(a * b / gcb(a, b));
        System.out.println(sb);
        br.close();
    }

    static int gcb(int a, int b) {
        if (b == 0)
            return a;
        return gcb(b, a % b);
    }

    static int gcbb(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
            return gcbb(a,b);
        }
        return a;
    }
}
