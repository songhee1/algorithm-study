package 브루트스포스;

import java.io.*;
import java.util.*;

/**
 * 덩치 등수 계산해 출력
 * 
 * 입력
 * 전체 사람 수 n,
 * 몸무게 + 키
 * 
 * 출력
 * 덩치 등수 구해서 순서대로 출력
 */
public class BOJ_7568again {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int arr[][];
    static int contest[];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        contest = new int[n];
        for (int i = 0; i < n; i++) {
            contest[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    contest[i]++;
                }
            }
        }

        for(int a : contest){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
