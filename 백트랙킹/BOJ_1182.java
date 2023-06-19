package 백트랙킹;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, s;
    static List<Integer> list = new LinkedList<>();
    static int arr[];
    static boolean visit[];
    static int objectnum = 1, prior;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[2000005];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (objectnum = 1; objectnum <= n; objectnum++) {
            backTracking(0);
        }

        System.out.println(prior);
    }

    static void backTracking(int count) {
        if (count == objectnum) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum == s) {

                prior++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[arr[i] + 1000000] == false) {
                if (count == 0 || (count > 0 && list.get(count - 1) <= arr[i])) {
                    visit[arr[i] + 1000000] = true;
                    list.add(arr[i]);
                    backTracking(count + 1);
                    list.remove(count);
                    visit[arr[i] + 1000000] = false;
                }
            }
        }
    }
}
