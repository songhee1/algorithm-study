import java.io.*;
import java.util.*;

public class BOJ_1904 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int dir[];
    static int n, order = 1;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dir = new int[1000005];
        dir[1] = 1;
        dir[2] = 2;

        for (int i = 3; i <= n; i++) {
            dir[i] = dir[i - 1] + order;
            order++;
        }

        System.out.print(dir[n]/15746);
        br.close();
    }
}
