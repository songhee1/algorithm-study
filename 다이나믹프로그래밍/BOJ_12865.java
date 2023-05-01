package 다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
    static int n, k, w, v;
    static int kg[], value[];
    static boolean isused[];
    static int maxValue, sumValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kg = new int[n];
        value = new int[n];
        isused = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            kg[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        kingOfValue(0, 0);

        System.out.print(maxValue);
        br.close();
    }

    static void kingOfValue(int r, int idx) {
        if (r == k) {
            maxValue = Math.max(maxValue, sumValue);
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!isused[i]) {
                isused[i] = true;
                sumValue += value[i];
                kingOfValue(r + kg[i], idx + 1);
                sumValue -= value[i];
                isused[i] = false;
            }
        }
    }
}
