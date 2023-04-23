package 집합과맵;

import java.io.*;
import java.util.*;

public class BOJ_7785 {
    static int n;

    public static void main(String[] arags) throws Exception {
        /*
         * Set: 이름 저장, 이름 제거 용도
         * List: Set 객체를 인자로 받아 list 객체 생성, 내림차순 정렬
         * ex.List<String> list = new ArrayList<String>(set)
         * 
         * 내림차순 정렬: List의 경우
         * >Collections.sort()(오름차순 정렬)
         * >Collections.sort(list, Collections.reverseOrder())(내림차순 정렬)
         * 
         * 시간: 724ms
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            st.nextToken();
            if (!s.contains(name))
                s.add(name);
            else
                s.remove(name);
        }
        List<String> list = new ArrayList<String>(s);

        Collections.sort(list, Collections.reverseOrder());

        for (String ss : list)
            sb.append(ss).append("\n");
        System.out.println(sb);
        br.close();
    }
}
