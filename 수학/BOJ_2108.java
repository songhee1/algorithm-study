package 수학;

import java.io.*;
import java.util.*;

public class BOJ_2108 {
    /*
     * 구해야할 값(*n은 홀수라고 가정)
     * 1. 산술평균(n개 수의 합을 n으로 나눈 값)
     * 2. 중앙값(n개 수를 오름차순으로 나열한 경우 중앙에 위치한 값)
     * 3. 최빈값(n개 수 중 가장 많이 나타나는 값)
     * 4. 범위(n개 수 중 최댓값과 최솟값의 차이)
     * 
     * 입력
     * n(1<=n<=500,000)(단, n은 홀수)
     * 
     * n개의 줄에는 정수 입력(-4,000<=정수<=4,000)
     */
    static int n;
    static int arr[];
    static int numOfAppeared[];
    static int sum;
    static int maxIdx, frequency;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        numOfAppeared = new int[8001];

        Vector<Integer> v = new Vector<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            numOfAppeared[i + 4000]++;
        }
        sb.append((int) (Math.round((double) sum / n))).append("\n");

        Arrays.sort(arr);
        sb.append(arr[n / 2]).append("\n");

        for (int i = 0; i < 8001; i++) {
            if (numOfAppeared[i] != 0) {
                if (numOfAppeared[maxIdx] < numOfAppeared[i]) {
                    maxIdx = i;
                    v.clear();
                } else if (numOfAppeared[maxIdx] == numOfAppeared[i]) {
                    if (v.contains(maxIdx - 4000)) {
                        v.add(i - 4000);
                    } else {
                        v.add(maxIdx - 4000);
                        v.add(i - 4000);
                    }
                }
            }
        }

        if (n == 1) {
            sb.append(arr[0]).append("\n");
            sb.append(0);
        } else {
            if (v.isEmpty()){
                System.out.println(maxIdx);
                sb.append(maxIdx - 4000).append("\n");
            }
            else
                sb.append(v.get(1)).append("\n");

            sb.append(arr[n - 1] - arr[0]);
        }

        System.out.print(sb);
        br.close();
    }
}
