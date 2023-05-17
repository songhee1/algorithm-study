package 다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class BOJ_12865{
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n, k; //물품수, 버틸수있는 무게
    static int weights[], values[];
    static int dp[][];

    public static void main(String[] args)throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weights = new int[n+1];
        values = new int[n+1];

        dp = new int [n+1][k+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(weights[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }
        
        System.out.print(dp[n][k]);
        br.close();
    }
}