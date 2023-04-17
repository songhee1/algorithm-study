package 정렬;

import java.io.*;
import java.util.*;

public class BOJ_11651 {
    static int n;
    static int arr[][];
    /*
     * 방법 : Arrays.sort()+BufferedReader+StringBuilder
     * 시간 : 776ms
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            //y좌표가 같으면 x좌표가 증가하는 순으로 정렬
            if (e1[1] == e2[1])
                return e1[0] - e2[0];
            else 
            //y좌표가 같지 않으면 y좌표가 증가하는 순으로 정렬
                return e1[1] - e2[1];
            

        });

        for (int i = 0; i < n; i++)
            sb.append(arr[i][0] + " " + arr[i][1] + "\n");

        br.close();
        System.out.println(sb);
    }
}
