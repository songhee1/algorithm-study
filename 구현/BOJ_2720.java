import java.io.*;
import java.util.*;

public class BOJ_2720 {
    static int testcase;
    static int c; // 거스름돈
    static int arr[] = { 25, 10, 5, 1 }; // 필요한 동전 개수
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            c = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
                if (c / arr[i] > 0) {
                    sb.append(c / arr[i]).append(" ");
                } else {
                    sb.append(0).append(" ");

                }
                c = c % arr[i];
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
