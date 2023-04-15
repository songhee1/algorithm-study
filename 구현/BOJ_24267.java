package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24267 {
    static int n;
    static long sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        /*
         * i는 n-2까지, j는 i보다는 크며 n-1까지, k는 j보다는 크며 n까지 반복하면서 뽑는 조합문제다.
         * i=1이면 j=2,3,4,5,6, j=2이면 k=3,4,5,6,7
         *                      j=3이면 k=4,5,6,7
         *                      j=4이면 k=5,6,7
         *                     ...
         * i,j,k로 갈수록 값이 커지고 하나씩만 뽑는 조합으로 푼다.
         * 
         * 
         * nCr=n!/(n-r)!r!
         * r이 3이므로  nC3=n!/(n-3)!3! 이며
         * nC3=n(n-1)(n-2)/6 이 된다.
         * 
         */
        bw.append(n*(n-1)*(n-2)/6 + "\n3");
        bw.close();
        br.close();
    }
}
