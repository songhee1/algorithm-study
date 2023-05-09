package 재귀;

import java.io.*;
import java.util.*;

public class BOJ_27433 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long n, result;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        System.out.print(factorial(n));
        br.close();
    }
    static long factorial(long r){
        if(r <= 1){
            return 1;
        }else{
            return r * factorial(r-1);
        }
    }
    
}
