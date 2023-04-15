package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2751 {
    static int n;
    static boolean arr[];
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        arr=new boolean[2000001];
        n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            arr[Integer.parseInt(br.readLine())+1000000]=true;
        }
        for(int i=0;i<2000001;i++){
            if(arr[i]){
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
