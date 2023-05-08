package 스택;

import java.io.*;
import java.util.*;

public class BOJ_1966copy {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int testcase; // 테케 개수
    static int n, m; // 문서의 갯수와 몇 번째로 출력되었는지 궁금한 문서의 인덱스 번호

    /**
     * [틀린 문제]
     * [아래는 올바른 코드]
     * - 중요도만 저장하는 것이 아니라, 처음 입력된 인덱스까지 저장한다.
     * - map처럼 두 개 원소를 같이 저장할 수 있으면서, 자유자재로 길이를 늘리고 줄일 수 있는
     * 링크드리스트를 사용한다.
     * - 사용해서 매번 뒤의 요소들 보다 크면 출력하고, 뒤의 요소들이 더 큰 경우 해당 요소까지 뒤로 다시 입력
     * - 맨 앞 요소가 가장 크다면, 인덱스가 찾고자 하는 인덱스와 같은지 비교 후 같다면 카운트 횟수 값 출력
     */

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < testcase; i++) {

            list.clear();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int r = Integer.parseInt(st.nextToken());
                list.offer(new int[] { j, r });// 0: 인덱스 번호, 1: 중요도
            }

            int count = 0;

            while (list.size() > 0) {
                int[] front = list.poll(); // 맨 앞 요소 추출
                boolean maxAppear = false;

                for (int j = 0; j < list.size(); j++) {
                    if (front[1] < list.get(j)[1]) {
                        maxAppear = true;

                        list.offer(front);

                        for (int k = 0; k < j; k++) {
                            list.offer(list.poll());
                        }
                        break;
                    }

                }
                // 0 2 
                //2

                if(maxAppear == true){
                    maxAppear = false;
                    continue;
                }

                count++;

                if (front[0] == m) {
                    sb.append(count).append("\n");
                    break;
                } 

            }

        }

        System.out.print(sb);
        br.close();
    }
}
