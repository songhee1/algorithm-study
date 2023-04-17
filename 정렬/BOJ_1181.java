package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1181 {
    static int n;
    static String arr[];
    /*
     * Arrays.sort()+ 단어 사전순 정렬(문자열1.compareTo(문자열2)) + StringBuilder + BufferedReader
     * 시간 : 380ms
     * 사전 순 정렬을 몰라서 compareTo 메서드를 풀지 못했다. 다시 풀어보기
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s;
        }
        Arrays.sort(arr, (e1, e2) -> {
            if (e1.length() == e2.length())
                return e1.compareTo(e2);
            else
                return (e1.length()) - (e2.length());
        });
        sb.append(arr[0] + "\n");
        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[i - 1]))
                sb.append(arr[i] + "\n");
        }
        System.out.print(sb);
        br.close();

    }
}
