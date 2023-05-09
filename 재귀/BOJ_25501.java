package 재귀;

import java.io.*;
import java.util.*;

public class BOJ_25501 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int testcase, count;
    static String s;
    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        while(testcase-- >0){
            s = br.readLine();
            
            sb.append(isPalindrom(s)).append(' ').append(count).append("\n");
            
            count = 0;
        }

        System.out.print(sb);
        br.close();
    }

    static int isPalindrom(String s){
        return recursion(s, 0, s.length()-1);
    }

    static int recursion(String s, int l, int r){
        count++;
        if(l>=r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}
