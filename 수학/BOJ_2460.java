package 수학;

import java.io.*;
import java.util.*;

public class BOJ_2460 {
    static int comeout, comein, subwayPeople;
    static int maxPeople;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            comeout = Integer.parseInt(st.nextToken());
            comein = Integer.parseInt(st.nextToken());
            subwayPeople += comein;
            subwayPeople -= comeout;
            if (maxPeople < subwayPeople)
                maxPeople = subwayPeople;
        }

        System.out.print(maxPeople);
        br.close();

    }
}
