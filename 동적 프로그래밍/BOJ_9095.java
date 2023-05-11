import java.io.*;
import java.util.*;

public class BOJ_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, testcase;
    static int dir[];
    static int arr[];

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {

            n = Integer.parseInt(br.readLine());

            dir = new int[100005];

            dir[1] = 1;
            dir[2] = 2;
            dir[3] = 4;

            for (int i = 4; i <= n; i++) {
                if (dir[i] == 0)
                    dir[i] = dir[i - 1] + dir[i - 2] + dir[i - 3];
                else
                    continue;
            }

            sb.append(dir[n]).append("\n");

        }

        System.out.print(sb);
        br.close();

    }
}
