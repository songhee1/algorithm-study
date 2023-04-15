package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class BOJ_2587 {
    static int arr[];
    static int sum = 0;
    static int tmp;
    static Vector<Integer> v = new Vector<>();

    /*
     * 선택정렬 + BufferedReader 
     * 시간 : 140ms
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 5; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        sb.append(sum / 5).append("\n").append(arr[2]);
        System.out.println(sb);
    }
}
