import java.io.*;
import java.util.*;
public class BOJ_2609 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int r = gcd(a, b);
        sb.append(r).append(" ").append(a * b/r);
        System.out.print(sb);
        br.close();
    }

    static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
