import java.io.*;
import java.util.*;
public class BOJ_2565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[][];
    static int dir[][];
    static int n;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[501][2];
        dir = new int[501][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                
            }
        }
    }
}
