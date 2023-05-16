package 덱;

import java.io.*;
import java.util.*;

public class BOJ_5430try {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, nums;
    static String p;
    static boolean isReverse = false, isError = false;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while (n-- > 0) {
            p = br.readLine();
            isError = false;
            isReverse = false;
            deque.clear();

            nums = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error").append("\n");
                        isError = true;
                        break;
                    }
                    if (isReverse == true) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError == true)
                continue;
            else {
                if(nums == 0){
                    sb.append("[]").append("\n");
                    continue;
                }
                if (isReverse == false) {
                    sb.append("[").append(deque.poll());
                    for (int a : deque) {
                        sb.append(",").append(a);
                    }
                } else {
                    sb.append("[").append(deque.pollLast());
                    for (int i = deque.size() - 1; i >= 0; i--) {
                        sb.append(",").append(deque.pollLast());
                    }
                }

                sb.append("]").append("\n");

            }

        }

        System.out.print(sb);
        br.close();

    }
}
