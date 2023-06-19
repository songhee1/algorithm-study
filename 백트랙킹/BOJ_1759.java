package 백트랙킹;

import java.io.*;
import java.util.*;

public class BOJ_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int l, c;
    static boolean visit[];
    static List<String> list = new LinkedList<>();
    static String arr[];
    static int vowelnum, nonvowelnum;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[c];
        visit = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        dfs(0, 0);

        System.out.println(sb);

    }

    static void dfs(int v, int at) {
        if (v == l) {
            int vowelNum = 0;
            int nvowelNum = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("a") || list.get(i).equals("e") || list.get(i).equals("i")
                        || list.get(i).equals("o")
                        || list.get(i).equals("u")) {
                    vowelNum++;
                } else {
                    nvowelNum++;
                }
            }

            if (vowelNum >= 1 && nvowelNum >= 2) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                }
                sb.append("\n");

            }

            return;
        }

        for (int i = at; i < c; i++) {
            if (visit[i] == false) {
                if (v == 0 || (v > 0 && list.get(v - 1).compareTo(arr[i]) <= 0)) {

                    visit[i] = true;
                    list.add(arr[i]);
                    dfs(v + 1, at + 1);
                    visit[i] = false;
                    list.remove(v);
                }
            }
        }
    }

}
