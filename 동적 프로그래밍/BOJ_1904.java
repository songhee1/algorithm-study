import java.io.*;
import java.util.*;

public class BOJ_1904 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int dir[];
    static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dir = new int[1000005];
        dir[1] = 1;
        dir[2] = 2;

        for (int i = 3; i <= n; i++) {
            dir[i] = (dir[i - 1] + dir[i-2])%15746;
        }

        System.out.print(dir[n]);
        br.close();
    }
}
