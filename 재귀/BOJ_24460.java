import java.io.*;
import java.util.*;

/**
 * nxn 명 사람들이 대회 참가
 * 한 명이면 특별상 바로 수상하지만, 여러명이면 정사각형 4개로 나눠 구역마다 한명씩 총 4명 뽑는다
 */
public class BOJ_24460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int arr[][];
    static List<Integer> minList = new LinkedList<>();
    static int minNum;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        if (n == 0) {
            arr = new int[1][1];
            arr[0][0] = Integer.parseInt(br.readLine());
            System.out.println(arr[0][0]);
        } else {
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                System.out.println(arr[0][0]);
            } else
                System.out.println(special(0, 0, n));

        }

    }

    static int special(int row, int col, int size) {
        List<Integer> list = new LinkedList<>();

        if (size == 2) {

            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    list.add(arr[i][j]);
                }
            }
            Collections.sort(list);
            return list.get(1);
        } else {

            int newSize = size / 2;
            list.add(special(row, col + newSize, newSize));
            list.add(special(row, col, newSize));
            list.add(special(row + newSize, col, newSize));
            list.add(special(row + newSize, col + newSize, newSize));

            Collections.sort(list);
            return list.get(1);
        }

    }
}
