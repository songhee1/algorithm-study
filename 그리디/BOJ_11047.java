package 그리디;

import java.io.*;

public class BOJ_11047 {
    static int n,k;
    static int coins[];

    static int sum, rest;
    static int index;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s= br.readLine();
        String []ss=s.split("\\s");
        
        n=Integer.parseInt(ss[0]);
        k=Integer.parseInt(ss[1]);

        coins=new int [10];
        for(int i=0;i<n;i++){
            coins[i]=Integer.parseInt(br.readLine());
        }

        for(int i=n-1;i>=0;i--){
            if(coins[i]<=k){
                sum+=k/coins[i];
                k=k%coins[i];
            }
        }

        bw.append(sum+"");
        bw.close();
        br.close();
    }
}
