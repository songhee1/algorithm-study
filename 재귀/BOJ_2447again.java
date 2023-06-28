import java.io.*;
import java.util.*;

public class BOJ_2447again {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char arr[][];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        find(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void find(int row, int col, int size) {
        if (size == 3) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (i == row + 1 && j == col + 1)
                        continue;
                    arr[i][j] = '*';
                }
            }
            return;
        }

        int newSize = size / 3;
        find(row, col, newSize);
        find(row, col + newSize, newSize);
        find(row, col + 2 * newSize, newSize);

        find(row + newSize, col, newSize);
        find(row + newSize, col + 2 * newSize, newSize);

        find(row + 2 * newSize, col, newSize);
        find(row + 2 * newSize, col + newSize, newSize);
        find(row + 2 * newSize, col + 2 * newSize, newSize);
    }
}
/**
 * 
 ***************************
 * ** ** ** ** ** ** ** ** *
 ***************************
 *** ****** ****** ***
 * * * ** * * ** * * *
 *** ****** ****** ***
 ***************************
 * ** ** ** ** ** ** ** ** *
 ***************************
 ********* *********
 * ** ** * * ** ** *
 ********* *********
 *** *** *** ***
 * * * * * * * *
 *** *** *** ***
 ********* *********
 * ** ** * * ** ** *
 ********* *********
 ***************************
 * ** ** ** ** ** ** ** ** *
 ***************************
 *** ****** ****** ***
 * * * ** * * ** * * *
 *** ****** ****** ***
 ***************************
 * ** ** ** ** ** ** ** ** *
 ***************************
 */