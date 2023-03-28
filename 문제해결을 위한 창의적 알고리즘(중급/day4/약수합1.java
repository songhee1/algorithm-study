import java.util.*;
import java.io.*;
public class 약수합1 {
    static long  n;
    static long sum;
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n=Long.parseLong(br.readLine());
        sum=1+n;
        for(long i=2;i*i<=n;i++){
            if(n%i==0){
                if(i*i==n) sum=sum+i;
                else sum=sum+i+n/i;
            }
        }

        bw.append(sum+"\n");
        bw.close();
        br.close();
    }
}
