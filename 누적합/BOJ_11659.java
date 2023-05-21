package 누적합;

import java.io.*;
import java.util.*;

public class BOJ_11659 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, sum;
    static int arr[];
    static int goingsum[][];

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        goingsum = new int[n][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            if(i!=0){
                goingsum[0][i]=goingsum[0][i-1]+arr[i];
            }else {
                goingsum[0][i]=arr[i];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                if(j!=i){
                    goingsum[i][j]=goingsum[i][j-1]+arr[j];
                }else{
                    goingsum[i][j]=arr[j];
                }
            }
        }

        while(m-- >0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(goingsum[a-1][b-1]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
