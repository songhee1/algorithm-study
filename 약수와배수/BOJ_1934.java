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
            result = 1;
            check=false;

            if ((a != 1 || b != 1)&& a!=b) {
                for (int j = 2; j <= b; j++) {
                    if (a % j == 0 && b % j == 0) {
                        result = (a / j) * (b / j) * j;
                        check=true;
                        break;
                    }
                }
                if(!check) result=a*b;
            }else if(a==b && (a!=1 || b!=1)) result=a; 
            else
                result = 1;

            sb.append(result).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
