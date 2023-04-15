package 정렬;

import java.util.*;
import java.io.*;

public class BOJ_11650 {
    static int arr[][];
    static int n, tmp[];

    /*
     * 선택정렬 + BufferedReader + StringBuilder
     * 시간 : 시간초과
     * 0번째 인덱스 값 기준 정렬 후, 값이 같으면 1번째 인덱스 값 기준 정렬
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("\\s");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else
                return e1[0] - e2[0];
        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
