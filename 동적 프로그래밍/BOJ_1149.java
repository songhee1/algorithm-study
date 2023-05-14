import java.io.*;
import java.util.*;

public class BOJ_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int arr[][];
    static int dir[][];
    static int n;

    public static void main(String[] args)throws Exception {
        n = Integer.parseInt(br.readLine());

        
        arr = new int [1005][3];
        dir = new int [1005][3];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dir[0][0] = dir[0][1] = dir[0][2] = arr[0][0] = arr[0][1] = arr[0][2] = 0;

        for(int i=1;i<=n;i++){
            dir[i][0] = Min(dir[i-1][1], dir[i-1][2]) + arr[i][0];
            dir[i][1] = Min(dir[i-1][0], dir[i-1][2]) + arr[i][1];
            dir[i][2] = Min(dir[i-1][0], dir[i-1][1]) + arr[i][2];
        }

        System.out.print(Min(Min(dir[n][0], dir[n][1]), dir[n][2]));
        
    }
    static int Min(int a, int b){
        return a>b? b : a;
    }
}
