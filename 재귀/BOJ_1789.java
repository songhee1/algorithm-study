import java.io.*;
import java.util.*;

public class BOJ_1789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, minusNum, zeroNum, oneNum;
    static int arr[][];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0, n);

        System.out.println(minusNum);
        System.out.println(zeroNum);
        System.out.println(oneNum);
    }

    static void find(int row, int col, int size) {
        if (check(row, col, size) == true) {
            int a = arr[row][col];
            if (a == -1)
                minusNum++;
            else if (a == 0)
                zeroNum++;
            else
                oneNum++;
            return;
        }

        int newSize = size / 3;
        find(row, col, newSize);
        find(row, col + newSize, newSize);
        find(row, col + 2 * newSize, newSize);

        find(row + newSize, col, newSize);
        find(row + newSize, col + newSize, newSize);
        find(row + newSize, col + 2 * newSize, newSize);

        find(row + 2 * newSize, col, newSize);
        find(row + 2 * newSize, col + newSize, newSize);
        find(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int a = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (a != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
