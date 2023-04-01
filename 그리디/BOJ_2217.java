package 그리디;

import java.io.*;
import java.util.*;

public class BOJ_2217 {
    static int N;
    static int maximum;
    static int count;
    static Vector<Integer> sumV = new Vector<>();
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
        
        for (int i = 0; i*i <= N; i++) {
            count = i + 1;
            collection(0);
        }
        bw.write(maximum + "");

        bw.close();
        br.close();
    }

    static void collection(int c) {
        if (c == count) {
            for (int i = 0; i < sumV.size(); i++) {
                System.out.print(sumV.get(i) + ", ");
            }
            System.out.println();
            if (maximum < sumV.lastElement() * count)
                maximum = sumV.lastElement() * count;
            System.out.println("maximum: " + maximum);
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (!visited[i]) {
                if ((sumV.size() > 0 && sumV.lastElement() >= v.get(i)) || sumV.size() == 0) {
                    visited[i] = true;
                    sumV.add(v.get(i));
                    collection(c + 1);
                    visited[i] = false;
                    sumV.remove(c);
                }
            }
        }
    }
}
