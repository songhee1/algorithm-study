package 수학;
import java.io.*;
import java.util.*;
class BOJ_2581{
    static int m,n,sum, firstPrime=-1;
    static boolean arr[];
    public static void main(String[] args)throws Exception {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        m=Integer.parseInt(br.readLine());
        n=Integer.parseInt(br.readLine());
        
        arr=new boolean[n+1];
        arr[0]=true;
        arr[1]=true;

        is_prime();

        for(int i=m;i<=n;i++){
            if(firstPrime==-1 && arr[i]==false){
                firstPrime=i;
                sum+=i;
            }else if(!arr[i]) {
                sum+=i;
            }
        }

        if(sum==0) sb.append(-1);
        else sb.append(sum).append("\n").append(firstPrime);
        System.out.print(sb);
        br.close();
    }

    static void is_prime(){
        for(int i=1;i<=Math.sqrt(n);i++){
            if(arr[i]) continue;
            for(int j=i*2;j<=n;j=j+i){
                arr[j]=true;
            }
        }
    }
}
