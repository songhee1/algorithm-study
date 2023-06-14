import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import javax.xml.transform.Source;
public class BOJ_11005redo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static long n, mok=1, rest=1;
    static int b;
    static String result = "";
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        
        n = Long.parseLong(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(n != 0){
            //0이면 탈출
            mok = n/b;
            rest = n%b;
            n = mok;
            
            char s ;
            if(rest >= 10){
                s = (char)(rest+55);
                result = s+ result;
            }else{
                result = (char)(rest + 48) + result;
            }
            
        }

        System.out.println(result);

    }
}
