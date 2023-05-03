package 스택;

import java.io.*;
import java.util.*;

public class BOJ_1874 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int arr[];
    static int pointer = 1;
    static int n, r;
    static int countingNumber = 1;
    static boolean flag = true;
    static int count;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        arr = new int[n+2];

        while (true) {
            count++;
            r = Integer.parseInt(br.readLine());

            if (arr[pointer-1] == r) {
                sb.append("-").append("\n");
                pointer -= 1;

            } else if (r < arr[pointer-1]) {
                flag = false;
                break;
            } else {

                for (; countingNumber <= r; countingNumber++) {
                    arr[pointer] = countingNumber;
                    sb.append("+").append("\n");
                    pointer += 1;
                }
                sb.append("-").append("\n");
                pointer -= 1;
            }

            if(r==1 && count==n) break; 
        }

        if(flag) System.out.print(sb);
        else System.out.print("NO");

        br.close();
    }
}
