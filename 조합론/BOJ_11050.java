package 조합론;
import java.io.*;
import java.util.*;
public class BOJ_11050 {
    static int n,m,num;
    static boolean isused[];
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        isused=new boolean[n+1];

        check(0,1);
        
        System.out.print(num);
        br.close();
    }
    static void check(int count,int r){
        if(count==m){
            num++;
            return;
        }
        for(int i=r;i<=n;i++){
            if(!isused[i]){
                isused[i]=true;
                check(count+1,i);
                isused[i]=false;
            }
        }
    }
}
