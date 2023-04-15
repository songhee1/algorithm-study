package 정렬;

import java.util.*;
import java.io.*;

public class BOJ_1427 {
    static int arr[];
    /*
     * 카운팅 정렬 이용, 해당 자리수(0~9)마다 증가된 수만큼 출력 후 1만큼 감소
     * 시간 : 124ms
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split("");
        arr = new int[10];

        for (int i = 0; i < s.length; i++)
            arr[Integer.parseInt(s[i])]++;

        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                sb.append(i).append("");
                arr[i]--;
            }
        }

        br.close();
        System.out.print(sb);
    }
}
