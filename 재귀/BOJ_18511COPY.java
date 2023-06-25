import java.io.*;
import java.util.*;

public class BOJ_18511COPY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, rest;
    static int arr[];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findNum(0);

        System.out.println(rest);

    }

    static void findNum(int now) {
        if (n < now)
            return; //n보다 큰수는 이 코드로 거르고 아래 분기에서는 
            //n보다 작지만 가장 큰 수로 교체되는 알고리즘이다.
        if (rest < now) {
            rest = now;
            System.out.println("rest: " + rest + ", now:" + now);
        }

        for (int i = k - 1; i >= 0; i--) {
            System.out.println(10 * now + arr[i]);
            findNum(10 * now + arr[i]);
        }
    }
}
