package BFS;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static boolean flag;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int nNum, mNum;
        nNum = n;
        mNum = m;

        if (n < m) {
            flag = true;
        } else
            flag = false;

        while (nNum != mNum) {
            if (flag) {
                if (nNum > mNum) {
                    count += (nNum - mNum)-1;
                    break;
                } else
                    nNum *= 2;
            } else {
                if (nNum < mNum) {
                    count += (mNum - nNum)-1;
                    break;
                } else
                    nNum /= 2;
            }
            count++;
        }

        System.out.println(count);
    }
}
