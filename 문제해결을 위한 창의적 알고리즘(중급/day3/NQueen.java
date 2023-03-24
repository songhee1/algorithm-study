package day3;

import java.io.*;

public class NQueen {
    static int N;
    static boolean isusedY[];
    static boolean isusedSum[];
    static boolean isusedMinus[];
    static int nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        isusedY = new boolean[N];
        isusedSum = new boolean[N * 2];
        isusedMinus = new boolean[N * 2];

        BackTracking(0);

        bw.append(nums + "\n");
        bw.close();
        br.close();
    }

    static void BackTracking(int x) {
        if (x == N) {
            nums++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((isusedY[i] == false) && (isusedSum[x + i] == false) && (isusedMinus[x - i + N - 1] == false)) {
                isusedY[i] = true;
                isusedSum[x + i] = true;
                isusedMinus[x - i + N - 1] = true;
                BackTracking(x + 1);
                isusedMinus[x - i + N - 1] = false;
                isusedSum[x + i] = false;
                isusedY[i] = false;
            }
        }
    }
}
