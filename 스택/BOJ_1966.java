package 스택;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int testcase; // 테케 개수
    static int n, m; // 문서의 갯수와 몇 번째로 출력되었는지 궁금한 문서의 인덱스 번호
    static int maxnum;
    static int pointer;
    static int check;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < testcase; i++) {
            q.clear();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            pointer = m;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int r = Integer.parseInt(st.nextToken());
                q.add(r);
                maxnum = Math.max(maxnum, r);
            }

            while (q.size()>0) {
                if (maxnum == q.peek()) {
                    check++;

                    if (pointer == 0) {
                        sb.append(check).append("\n");
                        break;
                    }
                    q.remove();
                    for (int k : q) {
                        maxnum = Math.max(0, k);
                    }

                } else {
                    q.add(q.poll());
                }

                pointer -= 1;
                if (pointer < 0) {
                    pointer = q.size() - 1;
                }

            }

        }

        System.out.print(sb);
        br.close();
    }
}
