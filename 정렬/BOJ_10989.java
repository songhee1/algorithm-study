package 정렬;

import java.util.*;
import java.io.*;

public class BOJ_10989 {
    static int n;
    static int arr[];
    static String s = "";

    public static void main(String[] args) throws Exception {
        /**
         * 0 1 2 3 4 5 6 7
         * 0 2 2 2 1 2 0 1
         * 
         * 0 1 2 3 4 5 6 7
         * 0 2 2 2 1 2 0 1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[10001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                bw.append(i + "\n");
            }
        }

        bw.close();
        br.close();
    }
}