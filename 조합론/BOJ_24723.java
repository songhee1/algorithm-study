package 조합론;
import java.util.*;
import java.io.*;

public class BOJ_24723 {
    static int n,count=1;
    /*
     * 층 수에 따라 2C1 반복(조합) 
     */
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            count*=2;
        }
        System.out.print(count);
        br.close();
    }
}
