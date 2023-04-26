package 약수와배수;
import java.io.*;
import java.util.*;
public class BOJ_4948 {
    static int n;
    static boolean prime[];
    static int count;
    /*
     * 에라토스테네스의 체 활용
     * 시간: 220ms
     */
    public static void main(String [] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        while(true){
            n=Integer.parseInt(br.readLine());
            if(n==0) break;

            count=0;
            prime=new boolean[2*n+1];
            prime[0]=true;
            prime[1]=true;
            get_prime();
            
            for(int i=n+1;i<=2*n;i++){
                if(!prime[i]) count++;
            }
            sb.append(count).append("\n");
        
        }
        System.out.print(sb);
        br.close();
        
    }
    static void get_prime(){
        for(int i=2;i<=Math.sqrt(2*n)+1;i++){
            if(prime[i]) continue;
            for(int j=i*2;j<=2*n;j=j+i){
                prime[j]=true;
            }
        }
    }
}
