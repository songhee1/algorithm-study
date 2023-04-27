package 조합론;

import java.io.*;
import java.util.*;
public class BOJ_15439 {
    static int n, num;
    static boolean isused[];
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        isused=new boolean[n+1];
        if(n!=1) check(0);
        System.out.print(num);
        br.close();
    }
    static void check(int count){
        if(count==2){
            num++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!isused[i]){
                isused[i]=true;
                check(count+1);
                isused[i]=false;
            }
        }
        return;
    }
}
