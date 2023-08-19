import java.io.*;
import java.util.*;
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int sum = 0;
        int total = n;
        int mok = 1;
        int namo = 1;
        while(total >= a ){
            mok = total/a;
            namo = total %a;
            sum += (mok * b);
            
            total = (mok * b) + namo;
            System.out.println(total);
        }
        
        return sum;
    }
}