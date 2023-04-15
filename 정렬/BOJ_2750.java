package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2750 {
    static int n, num, tmp;
    static boolean arr[];

    /*
     * 1. 선택정렬 +BufferedReader + BufferedWriter
     * 시간: 192ms
     * 
     * 2. 카운팅 정렬 + BufferedReader + StringBuilder
     * 시간: 144ms
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new boolean[2001];

        for (int i = 0; i < n; i++)
            arr[Integer.parseInt(br.readLine()) + 1000] = true;

        for (int i = 0; i < 2001; i++) {
            if (arr[i])
                sb.append(i-1000).append("\n");
        }
        System.out.println(sb);
        br.close();

    }
}
