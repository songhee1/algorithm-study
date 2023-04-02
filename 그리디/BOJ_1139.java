package 그리디;

import java.util.*;
import java.io.*;

public class BOJ_1139 {
    static int n;
    static int people[];
    static int sum,total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        String []ss=s.split("\\s");

        people=new int[n];

        for(int i=0;i<n;i++){
            people[i]=Integer.parseInt(ss[i]);
        }
        Arrays.sort(people);

        for(int i=0;i<n;i++){
            sum+=people[i];
            total+=sum;
        }

        bw.append(total+"");
        bw.close();
        br.close();
    }
}
