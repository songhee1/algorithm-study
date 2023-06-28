import java.io.*;
import java.util.*;

public class BOJ_17829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int arr[][];
    static StringTokenizer st;
    static List<Integer> minList = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(find(0, 0, n));


    }

    static int find(int row, int col, int size) {
        int[] newArr = new int[4];
        if (size == 2) {
            List<Integer> list = new LinkedList<>();
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    list.add(arr[i][j]);
                }
            }

            Collections.sort(list);
            return list.get(2);

        } else {

            int newSize = size / 2;
            newArr[0] = find(row, col + newSize, newSize);
            newArr[1] = find(row, col, newSize);
            newArr[2] = find(row + newSize, col, newSize);
            newArr[3] = find(row + newSize, col + newSize, newSize);

            Arrays.sort(newArr);
            return newArr[2];
        }
    }
}
