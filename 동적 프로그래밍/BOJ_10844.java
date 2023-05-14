import java.io.*;
import java.util.*;
public class BOJ_10844 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int dir[][];
    static int n;
    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        
        arr = new int[10000005];
        arr[0]=0;
        dir = new int[10000005][10];

        dir[1][0]=0;
        for(int i=1;i<=9;i++){
            dir[1][i]=1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j==0) dir[i][j] = dir[i-1][1];
                else if(j==9) dir[i][j] = dir[i-1][8];
                else dir[i][j] = dir[i-1][j-1] + dir[i-1][j+1];
            }
        }
        int sum=0;
        for(int i=0;i<=9;i++){
            sum += dir[n][i];
        }

        System.out.print(sum);
        br.close();
    }
}
