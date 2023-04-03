package 브루트스포스;

import java.util.*;
import java.io.*;

public class BOJ_2798 {
    static int n, m;
    static int answer[];
    // 카드 3장을 담은 배열

    static boolean isvisited[];
    // 카드가 선택되었는지 확인하는 용도의 배열

    static int closeN;
    // M에 가까운 수 저장

    static int sum;
    // 카드 3장의 합

    static int arr[];

    // 모든 카드를 담은 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] ss = s.split("\\s");
        n = Integer.parseInt(ss[0]);
        m = Integer.parseInt(ss[1]);

        String numbers = br.readLine();
        String[] nns = numbers.split("\\s");

        arr = new int[n];
        isvisited = new boolean[n];
        answer = new int[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nns[i]);
        }

        // 조합시작
        BTF(0);

        bw.append(closeN + "");
        br.close();
        bw.close();
    }

    static void BTF(int count) {
        if (count == 3) {
            for (int a : answer)
                sum += a;
            if (sum <= m)
                closeN = Math.max(closeN, sum);
            sum = 0;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isvisited[i]) {
                // 방문여부 확인

                if (count == 0 || (count > 0 && answer[count - 1] <= arr[i])) {
                    // 처음 방문 했거나 or answer 배열에 넣어져있는 이전 값보다 큰 값이면 코드 동작(조합사용)
                    isvisited[i] = true;
                    answer[count] = arr[i];
                    count++;
                    // count 증가시켜 재귀 활용
                    BTF(count);
                    count--;

                    // 사용했던 것은 지운다
                    answer[count] = 0;
                    isvisited[i] = false;
                }
            }
        }
    }
}
