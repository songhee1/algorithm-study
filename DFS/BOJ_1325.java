package DFS;

import java.io.*;
import java.util.*;

/**
 * 신뢰관계가 주어졌을때 한번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 출력
 * a->b a가 b를 신뢰할 경우 b해킹하면 a도 해킹할 수 있다.
 * 
 * 입력 : n(10,000>=n>=1), m(10,000>=n>=1)(m줄에 신뢰관계가 주어지고,
 * n번까지 번호가 매겨진다)
 * 관계 A B = A가 B를 신뢰한다는 의미
 * 컴퓨터는 1번부터 n번까지 번호가 매겨져 있다.
 * 
 * dfs로 풀면서, 인자로 graph내 숫자들을 조상으로 계속 넘겨주고 마지막에 map에 저장(조상번호, 자식수)
 */
public class BOJ_1325 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, count, maxNum;
    static boolean visit[];
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    static List<Integer>[] graph;
    static List<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            list.add(b);
        }

        for (int i = 0; i < list.size(); i++) {
            visit = new boolean[n + 1];
            count = 0;
            DFS(i);
            maxNum = Math.max(maxNum, count);
            map.put(i, count);

        }

        for (int key : map.keySet()) {
            if (map.get(key) == maxNum) {
                arrList.add(key);
            }
        }

        Collections.sort(arrList);

        for (Integer a : arrList) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);

    }

    static void DFS(int ancestor) {
        visit[ancestor] = true;
         for (int i = 0; i < graph[ancestor].size(); i++) {
            int a = graph[ancestor].get(i);
            if (visit[a] == false) {
                count++;
                DFS(a);
            }
        }
    }
}