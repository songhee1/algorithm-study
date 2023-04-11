package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24265 {
    static long n;
    static long sum;

    public static void main(String[] args) throws Exception {
        /*
         * [해결방법]
         * 첫번째 for문에서는 n-1번만큼 반복
            n=5라면
            i는 1~4까지만 반복, 총 4번 반복

            두번째 for문에서는 2~n번 =>j는 n-1번 반복
                i=1,j=2이면 2~5번, 총 4번 반복

                i=2, j=3, 3~n번 => n-2번 반복
                3~5번,총 3번 반복

                i=3, j=4, 4~n번=> n-3번 반복 ...
                4~5번, 총 2번 반복

                 i=4, j=5, 5~5번 반복, 총 1번 반복하고 끝난다

        따라서 총 10번 반복 

            --------------------------------------------------------------

            n=7이라면, 6+5+4+3+2+1

            (n-1)(n-1)

            *등차수열의 합 공식
            (long)n(n-1)/2
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        bw.append(n*(n-1)/2 + "\n");
        if(n==1) bw.append(0+"");
        else bw.append(2 + "");
        bw.close();
        br.close();
    }
}
