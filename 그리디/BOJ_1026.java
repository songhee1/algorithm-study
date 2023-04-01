package 그리디;

import java.util.*;
import java.io.*;

public class BOJ_1026 {
    static int n;
    static int a[];
    static Integer b[];
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new Integer[n];

        String s = br.readLine();
        String[] ss = s.split("\\s");

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(ss[i]);

        String bs = br.readLine();
        String[] bss = bs.split("\\s");

        for (int i = 0; i < n; i++)
            b[i] = Integer.parseInt(bss[i]);

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i=0;i<n;i++){
            sum+=a[i]*b[i];
        }
        bw.append(sum+"");
        bw.close();
        br.close();
    }
}
