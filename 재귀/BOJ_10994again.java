import java.io.*;
import java.util.*;

public class BOJ_10994again {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        int size = 4 * n - 3;
        arr = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = ' ';
            }
        }

        find(0, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void find(int point, int size) {
        if (size <= 1) {
            arr[point][point] = '*';
            return;
        }


        for(int i=point ; i<size;i++){
            arr[point][i]='*';
            arr[i][point]='*';
            arr[i][size-1]='*';
            arr[size-1][i]='*';
        }
        find(point+2, size - 2);
    }
}
