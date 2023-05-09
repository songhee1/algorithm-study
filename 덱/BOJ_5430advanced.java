package 덱;

import java.io.*;
import java.util.*;

public class BOJ_5430advanced {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int testcase;
    static String p;
    static int n;
    static boolean isRight = false;
    static boolean flag = false;
    static int pointer = 0, rearPointer;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        while (testcase-- > 0) {
            isRight = false;

            flag = false;

            p = br.readLine();

            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isRight = !isRight;

                } else if (p.charAt(i) == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error").append("\n");
                        flag = true;
                        break;
                    }
                    if (isRight == false) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if (flag == false) {
                sb.append("[");
                if (deque.size() > 0) {
                    if (isRight == false) {
                        sb.append(deque.pollFirst());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollFirst());
                        }
                    } else {
                        sb.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollLast());
                        }
                    }
                }

                sb.append("]").append("\n");
            }
        }

        System.out.print(sb);
        br.close();

    }

}
