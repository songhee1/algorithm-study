import java.io.*;
import java.util.*;

public class BOJ_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static String arr[][], s;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) + "";
            }
        }

        System.out.print(find(n, 0, 0));

    }

    static void find(int size, int row, int col) {
       
        String[] a = new String[4];
        
        if(check(size, row, col)){
           arr[row][col];
        }

            int newSize = size / 2;

            a[0] = find(newSize, row, col + newSize);
            a[1] = find(newSize, row + newSize, col);
            a[2] = find(newSize, row, col);
            a[3] = find(newSize, row + newSize, col + newSize);

        } else {
            return "(" + arr[row][col] + ")";
        }

        boolean isssam = true;
        for (int i = 1; i <4; i++) {
            if(a[0]!=a[i]){
                isssam=false;
            }
        }



    }
    static boolean check(int size, int row, int col){
        boolean isssame = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!arr[row][col].equals(arr[i][j])) {
                    isssame = false;
                    return false;
                }
            }
        }
        return true;

    }
}
