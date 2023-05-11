
import java.io.*;
import java.util.*;

public class BOJ_24416 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[], n;
    static int count, countbefore;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        arr[0] = 0;

        fibonaccibefore(n);
        fibonacci(n);

        sb.append(countbefore).append(" ").append(count);
        System.out.print(sb);
        br.close();
    }
    static int fibonaccibefore(int r){
        if(r == 1 || r == 2){
            countbefore++;
            return 1;
        }
        
        return fibonaccibefore(r-1)+fibonaccibefore(r-2);
        //f(4)+f(3)=f(3)+f(2)+f(2)+f(1)
    }

    static int fibonacci(int r){
        arr[1]=1;
        arr[2]=1;
        
        for(int i=3;i<=r;i++){
            arr[i]=arr[i-1]+arr[i-2];    
            count++;
        }

        return arr[r];
    }
}
