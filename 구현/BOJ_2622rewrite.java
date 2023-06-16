import java.io.*;
import java.util.*;

public class BOJ_2622rewrite {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long count, n;
    static StringBuilder sb = new StringBuilder();

    /*
     * 선형구조로 작성한 알고리즘
     * 
     * i는 j보다 작거나 같고, j는 k보다 작거나 같은 조건
     * 삼각형성립원리(i+j>k) 조건
     * 
     */
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n / 2; i++) {
            for (int j = i; j <= (n - i) / 2; j++) {

                long k = n - (i + j);
                if (i + j > k && i <= j && j <= k && i + j + k == n) {
                    count++;

                    // System.out.println(i + ", " + j + ", " + k);
                }
            }
        }

        System.out.println(count);
    }
}
