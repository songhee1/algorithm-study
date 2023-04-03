package 구현;

import java.util.*;
import java.io.*;
import java.nio.CharBuffer;

public class BOJ_11005 {
    static int n, b;
    static int mok = 1, namu;
    static String answer = "";
    static String a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] ss = s.split("\\s");
        List<Character> list = new ArrayList<>();

        n = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);

        while (mok != 0) {
            mok = n / b;
            namu = n % b;
            n = mok;
            if (namu > 9) {
                answer = (char) (namu + 55) + answer;
                //아스키코드 변환을 위해서 (char)로 형변환
                //몫이 10이상일 경우 10:A, 11: B, ... 35:Z 인데, A가 아스키코드 값으로 65이므로 55를 더하고 char형으로 바꾼다.
                

            } else {
                answer = namu + answer;
                //아스키코드 변환 필요없이, 9이하의 수는 그대로 문자 변환없이 들어가므로 형변환이 필요없다.
            }

        }

        bw.append(answer + "");
        bw.close();
        br.close();

    }

}
