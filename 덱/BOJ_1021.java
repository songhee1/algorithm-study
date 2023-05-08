package 덱;

import java.io.*;
import java.util.*;

public class BOJ_1021 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int count;

    /*
     * 링크드리스트에 1부터 n까지 수를 입력한다 (.add)
     * 찾고자 하는 값을 링크드리스트에 넣어둔다.
     * 
     * 
     * - 만약 찾고자 하는 값의 인덱스가 size/2보다 크다면 오른쪽으로 이동
     * -> int r= list.poll(), list.add(list.size()-1, r)
     * -> 리스트 크기 - 찾고자 하는 값의 인덱스 만큼 오른쪽으로 이동
     *
     * 
     * - 만약 인덱스가 size/2보다 작다면 왼쪽으로 이동
     * -> list.offer(list.poll())
     * -> 인덱스 크기만큼 이동
     * 
     * 위 두 가지 경우 다음에는, poll해준다.
     * 
     * 탈출조건 : m값들을 담은 리스트가 비어있으면 탈출
     *
     */
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> rightlist = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            rightlist.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        while (!rightlist.isEmpty()) {
            int find = rightlist.peek();

            if (find == list.peek()) {
                list.poll();
                rightlist.poll();
                continue;
            }

            int size = list.size();
            int idx = 0;

            for (int i = 0; i < list.size(); i++) {
                if (find == list.get(i))
                    idx = i;
            }

            if (idx > list.size() / 2) {
                for (int i = 0; i < list.size() - idx; i++) {
                    int r = list.get(size - 1);
                    list.pollLast();
                    list.add(0, r);
                    count++;
                }
            } else {
                for (int i = 0; i < idx; i++) {
                    list.offer(list.poll());
                    count++;
                }
            }

            for (int i : list) {
                System.out.print(i + " , ");
            }
            System.out.println();

        }

        System.out.print(count);
        br.close();

    }
}
