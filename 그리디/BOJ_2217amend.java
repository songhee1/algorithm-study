package 그리디;

import java.io.*;
import java.util.*;

public class BOJ_2217amend {
    static int N;
    static int maximum;
    static Vector<Integer> v = new Vector<>();
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            v.add(Integer.parseInt(s));
        }
        Collections.sort(v);

        for(int i=0;i<N;i++){
            int a=0;
            a=v.get(i)*(N-i);
            maximum=Math.max(maximum, a);
        }

        bw.write(maximum + "");

        bw.close();
        br.close();
    }

}
