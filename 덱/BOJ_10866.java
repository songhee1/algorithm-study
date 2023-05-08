package 덱;

import java.io.*;
import java.util.*;

public class BOJ_10866 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int test;
    static String order;
    static int num;

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();

        test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());

            order = st.nextToken();
            if (st.hasMoreTokens())
                num = Integer.parseInt(st.nextToken());
            switch (order) {
                case "push_back":
                    list.add(num);
                    break;

                case "push_front":
                    list.add(0, num);
                    break;

                case "pop_front":
                    if (list.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.poll()).append("\n");
                    break;

                case "pop_back":
                    if (list.isEmpty())
                        sb.append(-1).append("\n");
                    else {
                        sb.append(list.get(list.size() - 1)).append("\n");
                        list.remove(list.size() - 1);
                    }
                    break;

                case "size":
                    sb.append(list.size()).append("\n");
                    break;

                case "empty":
                    if (list.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;

                case "front":
                    if (list.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.peek()).append("\n");
                    break;

                case "back":
                    if (list.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.get(list.size() - 1)).append("\n");
                    break;

            }
        }

        System.out.print(sb);
        br.close();
    }
}
