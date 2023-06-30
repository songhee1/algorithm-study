import java.io.*;
import java.util.*;

public class BOJ_16505 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, n);

        arr = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = ' ';
            }
        }
        find(size, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                sb.append(arr[i][j]);
            }
            if (i == size - 1)
                continue;
            sb.append("\n");
        }

        System.out.print(sb);

    }

    private static void find(int size, int row, int col) {
        if (size == 0) {
            arr[row][col] = '*';
            return;
        }

        int newSize = size / 2;

        find(newSize, row + newSize, col); // 3사분면
        find(newSize, row, col + newSize); // 1사분면
        find(newSize, row, col); // 2사분면
    }
}
