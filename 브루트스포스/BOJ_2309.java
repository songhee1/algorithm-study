package 브루트스포스;

import java.util.*;
import java.io.*;

public class BOJ_2309 {
    static int arr[];
    static int answer[];
    static boolean findAnswer;
    static int sum;
    static boolean isvisited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[9];
        answer = new int[7];
        //일곱 난쟁이로 저장할 배열선언
        isvisited = new boolean[9];
        //방문했는지 여부판단에 쓰이는 배열 선언

        for (int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());

        BTF(0);
        //오름차순 배열로 정렬하기 위해 sort를 썼는데, 코딩테스트를 볼때는 sort를 쓰면 안된다고 한다.
        //sort를 쓰지 않고 다른 방법으로 정렬을 하는 것이 좋다.
        Arrays.sort(answer);
        for (int a : answer)
            bw.append(a + "\n");
        bw.close();
        br.close();
    }

    static void BTF(int count) {
        if (count == 7) {
            int subSum = 0;
            for (int a : answer)
                subSum += a;
            if (subSum == 100)
                findAnswer = true;
                //합이 100이면 바로 빠져나올수있게 boolean값을 참으로 하여 for문을 멈추고 출력하였다.
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isvisited[i]) {
                isvisited[i] = true;
                answer[count] = arr[i];
                count++;
                BTF(count);
                if (findAnswer)
                    break;
                count--;
                isvisited[i] = false;
                answer[count] = 0;
            } else
                break;

        }
    }
}
