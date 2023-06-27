import java.io.*;
import java.util.*;

/**
 * 전체 종이 크기 NXN(N=2^k승, k는 1이상 7이하 자연수)
 * 전체 종이가 같은 색으로 칠해져있지 않으면 가로세로 중간부분 잘라서 n/2, n/2 색종이로 나눈다
 * 모두 하얀색/파란색으로 칠해져있거나 하나의 정사각형 칸이 되어 더이상 자를수 없을때까지 반복
 * 
 * 최종 색종이의 갯수를 구하는 프로그램을 작성해라
 * 
 * 입력 : 전체종이의 한변의 길이n(하얀색:0, 파란색:1)
 * 출력 : 잘라진 하얀색 색종이 갯수 출력 후 파란색 종이갯수 출력
 */

public class BOJ_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int arr[][];
    static int n, blue, white;

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

        System.out.println(white);
        System.out.println(blue);
    }

    static void find(int row, int col, int size) {
        if (check(row, col, size) == true) {
            // blue: 1
            // white: 0

            int color = arr[row][col];
            if (color == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 2;
        find(row, col + newSize, newSize);
        find(row, col, newSize);
        find(row + newSize, col, newSize);
        find(row + newSize, col + newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int color = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
