import java.io.*;
import java.util.*;

public class BOJ_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int x;
    static int dir[];
    static int a, b, c;

    public static void main(String[] args) throws Exception {
        x = Integer.parseInt(br.readLine());

        dir = new int[x + 1];
        dir[1] = 0;

        for (int i = 2; i <= x; i++) {
            if (i % 6 == 0) {
                dir[i] = Math.min(dir[i - 1] + 1, Math.min(dir[i / 2] + 1, dir[i / 3] + 1));
            } else if (i % 2 == 0) {
                dir[i] = Math.min(dir[i - 1] + 1, dir[i / 2] + 1);
            } else if (i % 3 == 0) {
                dir[i] = Math.min(dir[i - 1] + 1, dir[i / 3] + 1);
            } else {
                dir[i] = dir[i - 1] + 1;
            }

        }

        System.out.print(dir[x]);
        br.close();
    }
}
