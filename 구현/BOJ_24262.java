package 구현;

import java.io.*;
import java.util.*;

public class BOJ_24262 {
    static int n, i;
    static int A[];
    static int rest;
    static int playtime;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        A = new int[500000];
        if (MenOfPassion(A, n) == 1) {
            rest = 0;
            playtime = 1;
        } else {

        }
        bw.append(playtime + "\n");
        bw.append(rest + "\n");
        bw.close();
        br.close();
    }

    //어떤 수가 와도 한번만 수행되기 때문에 1을 반환하게 된다. 어떤 값이 증감하는 식이 없기 때문
    static int MenOfPassion(int A[], int n) {
        count++;
        i = n / 2;
        return count; // 코드 1
    }
}
