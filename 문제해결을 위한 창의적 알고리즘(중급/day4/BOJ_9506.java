import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Comp implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
    }
}

public class BOJ_9506 {
    static int n;
    static int sum = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Vector<Integer> v = new Vector<>();

        while (true) {
            n = Integer.parseInt(br.readLine());

            v.clear();
            if (n == -1)
                break;

            sum = 1;
            v.add(1);
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i == n) {
                        sum += i;
                        v.add(i);
                    } else {
                        sum += i + n / i;
                        v.add(i);
                        v.add(n / i);
                    }
                }
            }
            if (sum == n) {
                Collections.sort(v);
                bw.append(n + " = ");
                for (int i = 0; i < v.size(); i++) {
                    if (i == v.size() - 1)
                        bw.append(v.get(i) + "\n");
                    else {
                        bw.append(v.get(i) + " + ");
                    }
                }
            } else {
                bw.append(n + " is NOT perfect.\n");
            }
        }

        bw.close();
        br.close();
    }
}
