package 에라토스테네스의체;

import java.io.*;
import java.util.*;

public class BOJ_11502 {
    static int testcase, n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[];
    static int anw[];
    static StringBuilder sb = new StringBuilder();
    static int what[];

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        arr = new int[1006];

        for (int i = 2; i < 1006; i++) {
            arr[i] = i;
        }

        for (int i = 2; i * i <= 1006; i++) {
            find(i);
        }

        while (testcase-- > 0) {
            n = Integer.parseInt(br.readLine());
            what = new int[3];
            isn();
        }

        System.out.println(sb);
    }

    static void find(int num) {
        for (int j = num + num; j < 1006; j += num) {
            arr[j] = 0;
        }

    }

    static void isn() {
        for (int i = 2; i < 1006; i++) {
            for (int j = 2; j < 1006; j++) {
                for (int k = 2; k < 1006; k++) {
                    if (arr[i] != 0 && arr[j] != 0 && arr[k] != 0) {
                        if (arr[i] + arr[j] + arr[k] == n) {
                            what[0] = arr[i];
                            what[1] = arr[j];
                            what[2] = arr[k];
                            Arrays.sort(what);
                            for (int h = 0; h < 3; h++) {
                                sb.append(what[h]).append(" ");
                            }
                            sb.append("\n");
                            return;
                        }
                    }
                }
            }
        }
        sb.append(0).append("\n");
    }
}
