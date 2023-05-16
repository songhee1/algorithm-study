import java.io.*;
import java.util.*;

public class BOJ_11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int frontdir[];
    static int reardir[];
    static int dir[];
    static int n;
    static boolean isNotAppeared = true;
    static int maxnum = 1;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        frontdir = new int[n];
        reardir = new int[n];
        dir = new int [n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            frontdir[i] = 1;
            reardir[i]=1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    frontdir[i] = Max(frontdir[i], frontdir[j] + 1);
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    reardir[i] = Max(reardir[i], reardir[j]+1);
                }
            }
        }

        for(int i=0;i<n;i++){
            dir[i] = frontdir[i]+ reardir[i];
        }

        for(int a:frontdir){
            System.out.print(a+", ");
        }
        System.out.println();

        for(int a:reardir){
            System.out.print(a+", ");
        }

        for(int a:dir){
            maxnum = Max(maxnum, a);
        }

        System.out.print(maxnum-1);
        br.close();

    }

    static int Max(int a, int b) {
        return a > b ? a : b;
    }
}
