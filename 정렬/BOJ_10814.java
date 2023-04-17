package 정렬;

import java.util.*;
import java.io.*;

public class BOJ_10814 {
    static int n;
    static String arr[][];
    static String s;
    /*
     * Comparator @Override + 2차원 배열에 인덱스값까지 저장 + StringBuilder + BufferedReader
     * 시간 : 948ms
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new String[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = i + "";
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0]))
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                else
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1] + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}
