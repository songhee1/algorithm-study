package 덱;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, testcase;
    static int maxnum, count;
    static boolean isFinished;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxnum = 0;
            count = 0;
            isFinished = false;

            map.clear();
            list.clear();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                list.add(a);
                map.put(a, j);
                maxnum = Math.max(list.peek(), maxnum);
            }

            while (isFinished == false) {
                if (maxnum == list.peek()) {
                    if (map.get(list.peek()) == m) {
                       isFinished=true;
                       count++;
                    } else {
                       list.add(list.poll());
                       count++;
                    }
                } else {
                    list.add(list.poll());
                }

            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
