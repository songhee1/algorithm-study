package 집합과맵;

import java.io.*;
import java.util.*;

public class BOJ_10815 {
    /*
     * 입력
     * 첫째 줄: 상근이가 가진 숫자카드의 갯수 N(1<=N<=500,000)
     * 둘째 줄: 숫자 카드에 적힌 정수는 -10,000,000보다 크거나 같고 10,000,000보다 작거나 같다)
     * 셋째 줄: 정수 M개(1<=M<=500,000)
     * 넷째 줄: M개에 해당하는 숫자카드, -10,000,000보다 크거나 같고 10,000,000보다 크거나 같다
     * 
     * 결과
     * 각 수가 적힌 숫자카드를 상근이가 가지고 있으면 1, 아니면 0 출력
     * 
     * 푼 방법
     * Set를 생각해보지 못하고 Map으로 풀려고 했는데 문제에 맞게 풀려면 Set에 적합
     * 시간: 964ms
     */
    static int sg, gest;
    static int sgArr[], gestArr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> m = new HashMap<>();
        sg = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sg; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (m.containsKey(a))
                continue;
            m.put(a, 1);
        }

        gest = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < gest; i++) {
            if (m.containsKey(Integer.parseInt(st.nextToken())))
                sb.append(1).append(' ');
            else
                sb.append(0).append(' ');
        }

        System.out.println(sb);
        br.close();

    }
}
