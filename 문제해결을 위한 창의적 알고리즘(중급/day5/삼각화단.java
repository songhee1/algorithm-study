package day5;

import java.util.*;
import java.io.*;

public class 삼각화단 {
    static int n, i;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        for(i=1;i<n;i++){
            if((n-i)%2==0){
               break; 
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                for(int k=j;k<=n;k++){
                    if(i+j+k==n && i+j>k){
                        cnt++;
                        bw.append(i+", "+j+", "+k+"\n");
                    }
                }
            }
        }

        bw.append(cnt + "\n");
        bw.close();
        br.close();
    }
}
