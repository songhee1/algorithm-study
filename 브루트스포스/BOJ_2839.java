package 브루트스포스;
import java.io.*;
import java.util.*;
public class BOJ_2839 {
    static int n, minNum;
    static int threeN;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        
        if(n%5==0){
            System.out.print(n/5);
        }else{
            int namu=n%5;
            int mok=n/5;
            if(namu%3==0){
                System.out.print(mok+namu/3);
            }else if(n%3==0){
                System.out.print(n/3);
            }
            else{
                System.out.print(-1);
            }
        }
    }
}
