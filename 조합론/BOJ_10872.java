package 조합론;
import java.io.*;
import java.util.*;
public class BOJ_10872 {
    static int n,result=1;
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        for(int i=2;i<=n;i++){
            result*=i;
        }
        System.out.print(result);
        br.close();
    }
}
