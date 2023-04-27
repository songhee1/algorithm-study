package 약수와배수;

import java.io.*;
import java.util.*;

public class BOJ_13909 {
    static long n, count;
    static boolean prime[];
    /*
     * 메모리 초과
     * 테스트케이스 중 24->4 나와야하는데 14가 출력
     * 문제점 찾지 못하였음
     */

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(br.readLine());
        prime=new boolean[n+1];
        for(int i=0;i<=n;i++) prime[i]=true;
        window();
        for(int i=1;i<=n;i++){
            if(prime[i]) count++;
        }
        sb.append(count);
        System.out.print(sb);
        br.close();
    }

    static void window() {
        for (long i = 2; i <= Math.sqrt(n) + 1; i++) {
            for (long j = i; j < prime.length; j = j + i) {
                if (prime[(int)j])
                    prime[(int)j] = false;
                else
                    prime[(int)j] = true;
            }
        }
    }
}
