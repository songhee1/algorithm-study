package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class BOJ_24263 {
    static int n;
    static int A[];
    static int i;
    static long sum;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = new int[500001];
        n = Integer.parseInt(br.readLine());
        bw.append(MenOfPassion(A, n) + "\n");
        bw.append(1 + "");
        bw.close();
        br.close();
    }
    //어떤 수가 오던지 상관없이 N까지 수행하고 나가기 때문에 O(N)이 되며, 따라서 차수는 1이 된다. 
    static int MenOfPassion(int A[], int n) {
        sum = 0;
        for (i = 1; i <= n; i++) {
            sum += A[i];
            count++;
        }
        return count;
    }
}
