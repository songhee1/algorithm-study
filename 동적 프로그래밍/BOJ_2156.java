import java.io.*;
import java.util.*;
public class BOJ_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int dir[];
    static int n;
    static int maxnum;
    public static void main(String[] args) throws Exception{
        n =Integer.parseInt(br.readLine());

        arr = new int[n+5];
        dir = new int[n+5];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dir[1] = arr[1];
        dir[2] = Max(arr[2], dir[1]+arr[2]);
        dir[3] = Max(arr[2]+arr[3], dir[1]+arr[3]);

        switch(n){
            case 1:
            maxnum = dir[1];
            break;

            case 2:
            maxnum = Max(dir[1], dir[2]);
            break;

            case 3:
            maxnum = Max(dir[1], Max(dir[2], dir[3]));
            break;
        }

        for(int i=4;i<=n;i++){
            dir[i] = Max(dir[i-2]+arr[i], dir[i-3]+arr[i-1]+arr[i]);
            dir[i] = Max(dir[i-1], dir[i]);
            
            System.out.println(i+", "+ dir[i]);
            maxnum = Max(dir[i], maxnum);
        }
        System.out.print(maxnum);
        br.close();
    }

    static int Max(int a, int b){
        return a>b ? a: b;
    }
}
