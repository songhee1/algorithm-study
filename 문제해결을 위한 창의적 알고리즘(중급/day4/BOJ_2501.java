import java.io.*;
import java.util.Collections;
import java.util.Vector;

public class BOJ_2501 {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Vector<Integer> v = new Vector<>();

        String s = br.readLine();
        String[] ss = s.split("\\s");

        N = Integer.parseInt(ss[0]);
        K = Integer.parseInt(ss[1]);

        v.add(1);
        v.add(N);

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N) {
                    v.add(i);
                } else {
                    v.add(i);
                    v.add(N / i);
                }
            }
        }

        Collections.sort(v);

        if (K > v.size()) {
            bw.append(0 + "\n");
        } else
            bw.append(v.get(K - 1) + "\n");
    
        bw.close();
        br.close();
    }
}
