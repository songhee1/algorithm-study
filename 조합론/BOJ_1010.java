
import java.io.*;
import java.util.*;

public class BOJ_1010 {
    static int t, n, m;
    static boolean isused[];
    static int arr[];
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            isused = new boolean[m];
            arr = new int[n];

            count = 0;
            makeThings(0, 0);

            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void makeThings(int r, int idx) {
        if (r == n) {
            count++;
            return;
        }

        for (int i = idx; i < m; i++) {
            if (r == 0) {
                if (!isused[i]) {
                    isused[i] = true;
                    arr[0] = i;
                    makeThings(r + 1, idx + 1);
                    isused[i] = false;
                }
            } else {
                if (!isused[i] && arr[r - 1] < i) {
                    isused[i] = true;
                    arr[r] = i;
                    makeThings(r + 1, idx + 1);
                    isused[i] = false;
                }
            }
        }
    }
}
