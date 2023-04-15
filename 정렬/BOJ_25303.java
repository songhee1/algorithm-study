package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_25303 {
    static int n, awardNum;
    static Integer arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        arr = new Integer[n];
        awardNum = Integer.parseInt(s[1]);

        String[] nums = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());

        sb.append(arr[awardNum - 1] + "");
        System.out.println(sb);
        br.close();
    }
}
