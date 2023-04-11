package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24264 {
    static long n;
    static int A[];
    static int i, j;
    static long sum;
    static int set1, set2;
    static long count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
         * 해결방법: 무슨 수가 오던지 간에, 실행횟수는 n*n이 되며, 다항식의 차수는 2가 된다.
         * 여기서는 MenOfPassion함수값의 정확한 반환값을 원하는 것이 아니므로 짧게 작성하도록 주의해야한다.
         */
        A = new int[500001];
        n = Long.parseLong(br.readLine());
        bw.append(MenOfPassion(A, n) + "\n");
        bw.append(set1 + set2 + "");
        bw.close();
        br.close();
    }

    static long MenOfPassion(int A[], long n) {
        sum = 0;
        for (i = 1; i <= n; i++) {
            set1 = 1;
            for (j = 1; j <= n; j++) {
                set2 = 1;
                break;
            }
            break;
        }
        count = n * n;
        return count;
    }
}