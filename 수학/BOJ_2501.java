package 수학;

import java.util.*;
import java.io.*;

public class BOJ_2501 {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Vector<Integer> v = new Vector<>();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i*i <=n; i++) {
            if (n % i == 0) {
                if (n / i == i)
                    v.add(i);
                else {
                    v.add(i);
                    v.add(n / i);
                }

            }
        }
        
        Collections.sort(v);

        if (v.size() <= k)
            System.out.print(0);
        else
            System.out.print(v.get(k-1));

        br.close();

    }
}
