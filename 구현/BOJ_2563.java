package 구현;
import java.util.*;
import java.io.*;
public class BOJ_2563 {
    static int arr[][];
    static int n;
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            String s=br.readLine();
            String []ss=s.split("\\s");
            arr[i][0]=Integer.parseInt(ss[0]);
            arr[i][1]=Integer.parseInt(ss[1]);
        }

        
    }
}
