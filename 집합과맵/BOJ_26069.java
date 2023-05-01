package 집합과맵;

import java.io.*;
import java.util.*;

public class BOJ_26069 {
    static int n;
    static String ss1, ss2;
    static boolean appear;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Set<String> s = new HashSet<>();

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ss1 = st.nextToken();
            ss2 = st.nextToken();

            if (ss1.equals("ChongChong") || ss2.equals("ChongChong")) {
                appear = true;
                s.add("ChongChong");
            }

            if (appear) {
                if (s.contains(ss1)) {
                    s.add(ss2);
                } else if (s.contains(ss2)) {
                    s.add(ss1);
                }
            }
        }

        System.out.print(s.size());
        br.close();
    }
}
