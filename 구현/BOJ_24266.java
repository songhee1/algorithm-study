package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24266 {
    static long n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bw.append(n * n * n + "\n3");
        bw.close();
        br.close();
    }
}
