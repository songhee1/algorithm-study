package 브루트스포스;

import java.util.*;
import java.io.*;

public class BOJ_1463 {
    static int n;
    static int count;
    static int i;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (i = 666;; i++) {
            /*666이 가장 먼저 나와야 하는 수이므로 초기화값으로 666을 하였다.
            연속으로 6이 3개 이상 나왔는지 확인하기 위해서는 10으로 나누어주거나 여러가지 방법이 있을텐데, 
            가장 먼저 떠오른 10으로 나누어주는 방법보다 직관적으로 알수있는 문자열 위치에서의 문자가 6인지 확인하는 방법으로 시도하였다.
            연속으로 6이 나오면 count값을 1 증가시키고 만약, 문제에서 알고싶어하는 n과 같아지면 출력되도록 하였다.
            */
            String s = "" + i;
            for (int j = 0; j < s.length(); j++) {
                if (j < s.length() - 2) {
                    if (s.charAt(j) == '6' && s.charAt(j + 1) == '6' && s.charAt(j + 2) == '6') {
                        count++;
                        break;
                    }
                }
            }
            if (count == n)
                break;
        }

        bw.append(i + "");
        bw.close();
        br.close();
    }
}
