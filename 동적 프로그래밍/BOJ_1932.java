import java.io.*;
import java.util.*;

public class BOJ_1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int arr[][];
    static int dir[][];
    static int n;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[502][502];
        dir = new int[502][502];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dir[i][j] = Min(dir[i-1][j-1], dir[i-1][j]) + arr[i][j];
            }
        }

        int minnum = dir[n][1];
        for(int i=2;i<=n;i++){
            minnum = Min(minnum, dir[n][i]);
        }

        System.out.print(minnum);
        
    }

    static int Min(int a, int b){
        return a>b ? a : b;
    }
}
