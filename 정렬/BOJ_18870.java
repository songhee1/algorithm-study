package 정렬;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
    static int n, count;
    static int arr[], sorting[];

    /*
     * 입력제한
     * 1<= N <=1,000,000
     * -10^9 <= Xi <=10^9
     * 
     * 입력 첫째줄 : N, 둘째 줄: X1,X2, X3, ..., Xn
     * 결과 정렬 한 순서를 처음 입력 받은 수들의 위치 그대로에 출력
     * 
     * 정렬한 후, map에 키값이 없으면 continue해서 넘어가고, map에 키 값이 있으면 put하고 i++
     * 
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> m = new HashMap<>();

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sorting = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            sorting[i] = a;
        }

        Arrays.sort(sorting);

        for (int i = 0; i < n; i++) {
            if (m.containsKey(sorting[i]))
                continue;
            m.put(sorting[i], count);
            count++;
        }

        for (int i = 0; i < n; i++)
            sb.append(m.get(arr[i])).append(' ');

        br.close();
        System.out.print(sb);
    }
}
