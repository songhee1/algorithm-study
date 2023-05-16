package 덱;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, testcase;
    static int maxnum, idx, present;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxnum = 0;
            idx = 0;

            map.clear();
            list.clear();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
                maxnum = Math.max(list.peek(), maxnum);
            }

            map.put(m, 0);
            present = m;
            while (idx == 0) {
                if (maxnum == list.peek()) {
                    if (present == 0) {
                        idx = map.get(m) + 1;
                    } else if (present > 0) {
                        map.replace(m, map.get(m) + 1);
                    }
                    list.poll();
                } else {
                    list.add(list.poll());
                }

                present--;
                if (present < 0) {
                    present = list.size() - 1;
                }
            }

            sb.append(idx).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
