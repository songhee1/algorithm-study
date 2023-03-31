package day6;

import java.util.*;
import java.io.*;

public class 고기잡이 {
    static int n, m, w, h;
    static int graph[][];
    static int sum = 0;
 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String[] fs = first.split("\\s");
        n = Integer.parseInt(fs[0]);
        m = Integer.parseInt(fs[1]);

        String second = br.readLine();
        String[] ses = second.split("\\s");
        w = Integer.parseInt(ses[0]);
        h = Integer.parseInt(ses[1]);

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] ss = s.split("\\s");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(ss[j]);
            }
        }

        int end_ypoint=w-1;
        int end_xpoint=h-1;
        for(int i=0;i<n-(w-1);i++){
            for(int j=i;j<i+h;j++){
                if(j==)
            }
        }

        bw.append(sum + "\n");
        bw.close();
        br.close();

    }
}
