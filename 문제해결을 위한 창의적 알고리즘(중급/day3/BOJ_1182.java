package day3;

import java.io.*;

public class BOJ_1182 {
    static int N, S;
    static int num;// 부분 수열의 원소의 갯수(1개~N개)
    static boolean isused[];
    static int array[];
    static int count;// 합이 S가 되는 부분 수열의 갯수
    static int sumAry[];
    static boolean isfirstelement = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        String[] stringAry = string.split("\\s");

        N = Integer.parseInt(stringAry[0]);
        S = Integer.parseInt(stringAry[1]);

        array = new int[N];
        isused = new boolean[N];
        sumAry = new int[N];

        String s = br.readLine();
        String[] sAry = s.split("\\s");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(sAry[i]);
        }

        for (int i = 1; i <= N; i++) {
            BackTracking(0, i);
        }

        bw.append(count + "\n");
        br.close();
        bw.close();
    }

    static void BackTracking(int n, int num) {
        if (n == num) {
            int sum = 0;
            for (int a : sumAry) {
                sum += a;
            }
            System.out.println();
            if (sum == S) {
                count++;
                System.out.print(n + ": ");
                for (int a : sumAry) {
                    System.out.println(a + ", ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isused[i] == false) {
                isused[i] = true;
                sumAry[n] = array[i];
                BackTracking(n + 1, num);
                isused[i] = false;
                sumAry[n] = 0;
            }
        }

    }
}
