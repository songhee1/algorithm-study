package 브루트스포스;

import java.util.*;
import java.io.*;

/*처음 생각한 아이디어
 * 1. x+y+z+100x+10y+z=101x+11y+2z=n과 같다는 방정식 설정
 * 2. x와 y에 차례대로 1~9 숫자 대입하며 z값이 정수로 나오는 지점 발견하면 끝남
 * 
 * 1. n 을 2로 나누어 나온 값부터 생성자인지 확인
 */

public class BOJ_2231amend {
    static int n;
    static int answer;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int namu=0;
        for(int i=0;i<n;i++){
            n=n%10
        }

        bw.close();
        br.close();
    }
}
