package 수학;
import java.util.*;
import java.io.*;
public class BOJ_10870 {
    static int n, arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        arr[0]=0;

        if(n>0){
        arr[1]=1;
        }

        for(int i=2;i<=n;i++){
           arr[i]=arr[i-1]+arr[i-2];
        }

        System.out.print(arr[n]);
        br.close();
    }
}
