import java.io.*;
import java.util.*;

public class BOJ_1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long arr[];
    static long dir[];
    static long n, maxnum;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dir = new long[1000000];
        st = new StringTokenizer(br.readLine());
        arr = new long[1000000];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
         * 현재 값arr[i]+ dir[i-1], arr[i] 값 비교(더 큰 값을 dir[i]에 대입)
         * - 단, 둘의 합이 음수일 경우 arr[i]값을 dir[i]에 대입
         */

        for (int i = 0; i < n; i++) {
            if (i == 0){
                dir[0] = arr[0];
                continue;
            }
            long r = arr[i] + dir[i - 1];
            if (r < 0) {
                dir[i] = arr[i];
            } else {
                dir[i] = Math.max(arr[i] + dir[i - 1], arr[i]);
            }

        }

        maxnum = dir[0];

       for(int i=1;i<n;i++){
            maxnum = Math.max(maxnum, dir[i]);
       }

        System.out.print(maxnum);
        br.close();
    }
}