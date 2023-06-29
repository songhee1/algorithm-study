import java.io.*;
import java.util.*;

public class BOJ_18222 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long k;
    static String anw;

    public static void main(String[] args) throws Exception {
        k = Long.parseLong(br.readLine());

        int a = 1;
        for (int i = 1;; i *= 2) {
            if (k < i) {
                a = i;
                break;
            }
        }
        anw = toemos(a);
        System.out.println(anw.charAt((int) k - 1));

    }

    private static String toemos(long n) {
        if (n == 1) {
            String s = String.valueOf(0);
            return s;
        }

        String s = toemos(n / 2); // 8
        long a =Long.parseLong(s);
        a = ~a;
        System.out.println(a);

        return s + String.valueOf(a);

    }
}
