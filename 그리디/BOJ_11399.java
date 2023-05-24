package 그리디;
import java.io.*;
import java.util.*;

public class BOJ_11399 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int arr[];
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum=0;
        int totalSum=0;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            totalSum += sum;
        }

        System.out.print(totalSum);
    }
}
