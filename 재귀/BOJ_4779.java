package 재귀;

import java.io.*;
import java.util.*;


public class BOJ_4779 {
    static StringTokenizer st;
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /*
     * 1. -가 3의 n 있는 문자열 시작
     * 2. 문자열 3등분, 가운데 문자열 공백
     * 3. 남은 문자열 3등분, 가운데 문자열 공백...길이 1될때까지 반복
     * 
     * 최대입력 : N=12
     */

    public static void main(String[] args) throws Exception{

        String input;
        while((input = br.readLine())!=null){
           
            int nums = (int)Math.pow(3, Integer.parseInt(input));
            sb = new StringBuilder();
            for(int i=1;i<=nums;i++){
                sb.append("-");
            }
            
            recall(0, nums);

            System.out.print(sb);
            
        }
        br.close();
    }
    static void recall(int startidx, int size){
        if(size==1){
            return;
        }

        int b = size/3;
        for(int i=startidx+b ; i<startidx+2*b ;i++){
            sb.setCharAt(i, ' ');
        }

        recall(startidx, b);
        recall(startidx+2*b, b);
    }
}
