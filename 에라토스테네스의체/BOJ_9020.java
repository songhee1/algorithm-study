package 에라토스테네스의체;

import java.io.*;
import java.util.*;

public class BOJ_9020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int testcase, n, minNum;
    static int a, b;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());
        arr = new int[10000];
        for (int i = 2; i < 10000; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < 10000; i++) {
            if (arr[i] != 0) {
                find(i);
            }
        }

        while (testcase-- > 0) {
            n = Integer.parseInt(br.readLine());
            goldbagh();
        }
        System.out.print(sb);
    }

    static void find(int num) {
        for (int i = num * 2; i < 10000; i += num) {
            arr[i] = 0;
        }
    }

    static void goldbagh() {

        int banone = n / 2;
        int bantwo = n - n / 2;

        while (true) {
            if (arr[banone] != 0 && arr[bantwo] != 0 && banone + bantwo == n) {
                if (banone > bantwo) {
                    int tmp = banone;
                    banone = bantwo;
                    bantwo = tmp;
                }
                sb.append(banone).append(" ").append(bantwo).append("\n");
                return;
            }
            banone--;
            bantwo++;
        }
    }
}
