import java.io.*;
import java.util.*;

import javax.swing.Action;

public class BOJ_2745 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        String n;
        int b, asci = 0;
        long sum = 0;
        int idx = 0;
        n = st.nextToken();
        b = Integer.parseInt(st.nextToken());

        for (int i = n.length() -1; i >=0; i--) {
            char s = n.charAt(i);
            System.out.println(n.charAt(i));
            System.out.println("s:" + s);
            if (s >= 'A' && s <= 'Z') {
                asci = s - 55;
            }else{
                asci = s - '0';
            }
            System.out.println("asci : "+asci);
            sum += Math.pow(b, idx++) * asci;
            System.out.println("sum : "+sum);
        }

        System.out.println(sum);
    }
}