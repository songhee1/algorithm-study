import java.io.*;
import java.util.*;

public class BOJ_10997 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        int a = 4 * n - 3;
        arr = new char[a + 2][a];

        for (int i = 0; i < a + 2; i++) {
            for (int j = 0; j < a; j++) {
                if (i != 1)
                    arr[i][j] = ' ';
            }
        }
        find(a + 2, a, 0, 0);

        for (int i = 0; i < a + 2; i++) {
            for (int j = 0; j < a; j++)

                System.out.print(arr[i][j]);
            if (i != a + 1)
                System.out.println();
        }

    }

    static void find(int rowsize, int colsize, int row, int col) {
        if (colsize <= 3) {
            for (int i = col; i < col + 3; i++) {
                arr[row][i] = '*';
            }
            for (int i = row; i < row + 3; i++) {
                arr[i][col] = '*';
            }
            return;
        } else {
            find(rowsize - 4, colsize - 4, row + 2, col + 2);
            for (int i = col; i < col + colsize; i++) {
                arr[row][i] = '*';
            } // 맨위 가로줄

            for (int i = row; i < row + rowsize; i++) {
                arr[i][col] = '*';
            } // 맨 왼쪽 세로줄

            for (int i = col; i < col + colsize; i++) {
                arr[row + rowsize - 1][i] = '*';
            }

            for (int i = row + 2; i < row + rowsize; i++) {
                arr[i][col + colsize - 1] = '*';
            }

            arr[row + 2][col + colsize - 2] = '*';

        }
    }
}