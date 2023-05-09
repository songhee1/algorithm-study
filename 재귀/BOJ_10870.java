package 재귀;

import java.io.*;
import java.util.*;

public class BOJ_10870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, result;
    static int arr[];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        if (n >= 1) {
            arr[1] = 1;
            result = pivonachi(n);
        } else {
            result = arr[n];
        }

        System.out.print(result);
        br.close();
    }

    static int pivonachi(int r) {
        if (r == 1)
            return 1;
        if (r == 0)
            return 0;

        arr[r] = pivonachi(r - 1) + pivonachi(r - 2);

        // arr[2]=pivonachi(1)+pivonachi(0)=1
        // arr[3]=pivonachi(2)+pivonachi(1)=1+1=2

        return arr[r];
    }

}
