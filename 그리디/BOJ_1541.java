package 그리디;
import java.io.*;
import java.util.*;


public class BOJ_1541 {
    static StringTokenizer st;
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int sum=5;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine(),"-");
        
        while(st.hasMoreTokens()){
            int tmp=0;
            
            StringTokenizer sa = new StringTokenizer(st.nextToken(), "+");

            while(sa.hasMoreTokens()){
                tmp += Integer.parseInt(sa.nextToken());
            }

            if(sum == 5){
                sum = tmp;
            }else{
                sum-=tmp;
            }
        }

        System.out.print(sum);
        br.close();
    }
}
