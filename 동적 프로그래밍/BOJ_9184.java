import java.io.*;
import java.util.*;

public class BOJ_9184 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a, b, c;
    static int testcase;
    static int arr[][][];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[a + 1][b + 1][c + 1];

        int r = w(a, b, c);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                for(int k=0;k<arr[j].length;k++){
                    System.out.println(arr[i][j][k]);
                }
            }
        }

        System.out.print(r);

    }

    static int w(int a, int b, int c){
       arr[0][0][0]=1;
       arr[0][0][1]=1;
       arr[0][1][0]=1;
       arr[0][1][1]=1;
       arr[1][0][0]=1;
       arr[1][0][1]=1;
       arr[1][1][0]=1;

        if(a>20) a=20;
        if(b>20) b=20;
        if(c>20) c=20;

        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                for(int k=1;k<=c;k++){
                   if(i<j && j<k){
                     arr[i][j][k]=arr[i][j][k-1]+arr[i][j-1][k-1]-arr[i][j-1][k];
                   }else{
                    arr[i][j][k]=arr[i-1][j][k]+arr[i-1][j-1][k]+arr[i-1][j][k-1]-arr[i-1][j-1][k-1];
                   }
                }
            }
        }
        return arr[a][b][c];
    }
}
