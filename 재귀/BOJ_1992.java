import java.io.*;
import java.util.*;

public class BOJ_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int arr[][];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int [n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        find(n, 0, 0);
        System.out.print(sb);

    }

    static void find(int size, int row, int col) {

        if (check(size, row, col)) {
            sb.append(arr[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        find(newSize, row, col);
        find(newSize, row, col + newSize);
        find(newSize, row + newSize, col);
        find(newSize, row + newSize, col + newSize);
        sb.append(")");

    }

    static boolean check(int size, int row, int col) {
        boolean isssame = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[row][col] != arr[i][j]) {
                    isssame = false;
                    return false;
                }
            }
        }
        return true;

    }
}
