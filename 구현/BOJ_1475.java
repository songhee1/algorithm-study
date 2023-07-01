package 구현;

import java.io.*;
import java.util.*;

public class BOJ_1475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new LinkedList<>();
    static int n, count;
    static int arr[];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        int a = 1;
        int b = 1;
        arr = new int[10];
        while (a > 0) {
            a = n / 10;
            b = n % 10;
            n = a;

            if (b == 6 || b == 9) {
                if (arr[6] <= arr[9]) {
                    arr[6]++;
                } else if (arr[6] > arr[9]) {
                    arr[9]++;
                }
            } else {
                arr[b]++;
            }
        }

        int maxSum = 0;
        for (int i = 0; i < 10; i++) {
            maxSum = Math.max(maxSum, arr[i]);
        }

        System.out.println(maxSum);
    }
}