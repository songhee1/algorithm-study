package 그리디;

import java.io.*;
import java.util.*;

public class BOJ_1931 {
    static int meeting;
    static int arr[][];
    static int firstIndex;
    static int lastIndex;
    static int len;
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        meeting = Integer.parseInt(br.readLine());
        arr = new int[meeting][2];

        for (int i = 0; i < meeting; i++) {
            String[] s = br.readLine().split("\\s");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);

        }

        Arrays.sort(arr, new Comparator<int[]>() { // new Comparator 함수 Override
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 첫번째 원소의 값이 같을 때 두번쨰 원소의 값을 기준으로 정렬
                    return o1[0] - o2[0];
                } else { // 같지 않을 시 첫번째 원소를 기준으로 정렬
                    return o1[1] - o2[1];
                }
            }
        });

        int idx=arr[0][1];
        sum++;
        for (int i = 1; i < meeting; i++) {
            int index=arr[i][0];
            if(idx<=index){
                idx=arr[i][1];
                sum++;
            }
        }

        bw.append(sum+"");
        bw.close();
        br.close();
    }
}
