package 스택;

import java.io.*;
import java.util.*;

public class BOJ_10773 {
    static long sum;
    static int  n,num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            num=Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        for(Integer number:stack) sum+=number;
        System.out.print(sum);
        br.close();
    }
}
