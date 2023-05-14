import java.io.*;
import java.util.*;

public class BOJ_2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int dir[];
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int [305];
        dir = new int [305];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dir[0] = arr[0];
        dir[1] = Max(dir[0]+arr[1], arr[1]);
        dir[2] = Max(dir[1]+arr[2], dir[0]+arr[2]);

        for(int i=3;i<n;i++){
            dir[i] = Max(dir[i-3]+arr[i-1]+arr[i], dir[i-2]+arr[i]);
        }

        System.out.print(dir[n-1]);
    }

    static int Max(int a, int b){
        return a>b? a : b;
    }
}
