package 구현;

import java.io.*;
import java.util.*;

public class BOJ_19311 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static long arr[][];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return (int)(o1[1]-o2[1]);
            }
            return (int)(o1[0] - o2[0]);
        });

        int maxNum = 0;
        for(int i=0;i<=n;i++){
            long end = arr[i][1];
            int num = 1;

            for(int j=i+1;j<n;j++){
                if(end <= arr[j][0]){
                    num += 1;
                    end = arr[j][1];
                }
            }
            maxNum = Math.max(num, maxNum);

        }

        System.out.print(maxNum);
        br.close();
    }
}
