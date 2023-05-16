import java.io.*;
import java.util.*;

public class BOJ_11053 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int dir[];
    static int n;
    static int maxnum = 1;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[1005];
        dir = new int[1005];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dir[0] = 1;
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dir[i] = Max(dir[j] + 1, dir[i]);
                }
            }
        }

        for (int a : dir) {
            if (a > maxnum)
                maxnum = a;
        }

        System.out.print(maxnum);
    }

    static int Max(int a, int b) {
        return a > b ? a : b;
    }
}
