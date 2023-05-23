package 그리디;
import java.io.*;
import java.util.*;

public class BOJ_1789 {
    static int s;
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws Exception {
        s = Integer.parseInt(br.readLine());
        int tmp=1;
        while(s != 0){
            s -= tmp;
            tmp+=1;
        }
        
    }
    
}
