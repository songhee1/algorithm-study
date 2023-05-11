import java.io.*;
import java.util.*;

public class BOJ_1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long p[];
    static long n, maxnum, sum;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        p = new long[1000000];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        maxnum = p[0];
        for(int i=0;i<n;i++){
            for(int j=i;j<=n;j++){
                sum+= p[j];
                maxnum = Math.max(sum, maxnum);
            }
        }

        System.out.print(maxnum);
        br.close();
    }
}