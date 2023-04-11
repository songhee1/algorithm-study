package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24264 {
    static long n;
    static int A[];
    static int i, j;
    static long sum;
    static int set1, set2;
    static long count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = new int[500001];
        n = Long.parseLong(br.readLine());
        bw.append(MenOfPassion(A, n) + "\n");
        bw.append(set1 + set2 + "");
        bw.close();
        br.close();
    }

    static long MenOfPassion(int A[], long n) {
        sum = 0;
        for (i = 1; i <= n; i++) {
            set1 = 1;
            for (j = 1; j <= n; j++) {
                set2 = 1;
                break;
            }
            break;
        }
        count = n * n;
        return count;
    }
}