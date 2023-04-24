package 집합과맵;

import java.io.*;
import java.util.*;

public class BOJ_1764 {
    static int n, m;
    static int count;
    /*
     * HashSet 2개를 이용해서 두 조건 모두에 해당하는 문자열 저장
     * 시간 : 336ms
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> s = new HashSet<>();
        Set<String> s2=new HashSet<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
            s.add(br.readLine());

        for (int i = 0; i < m; i++) {
            String ss = br.readLine();
            if (s.contains(ss)) {
               s2.add(ss);
            }
        }
        List<String> list=new ArrayList<>(s2);
        Collections.sort(list);

        sb.append(s2.size()).append("\n");
        for (String sss : list) {
            sb.append(sss).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
