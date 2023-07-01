package 에라토스테네스의체;

import java.io.*;
import java.util.*;

public class BOJ_2960 {
    static int arr[];
    static int n, k, count;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            arr[i] = i;
        }

        while (true) {
            boolean a = false;
            for (int i = 2; i < n + 1; i++) {
                if (arr[i] != 0) {
                    a = find(arr[i]);
                    if (a == true) {
                        return;
                    }
                }
            }
        }
        // 2 4 6 8 10 12 14 지워짐
        // 3 5 7 9 11 13 15
    }

    static boolean find(int num) {
        for (int i = num;; i += num) {
            if (i > n) {
                return false;
            } else if(arr[i]!=0) {
                count++;
                if (count == k) {
                    System.out.print(arr[i]);
                    return true;
                }
                arr[i] = 0;
            }
        }
    }
}
