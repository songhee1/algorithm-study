package 정렬;

import java.util.*;
import java.io.*;

public class BOJ_10989 {
    static int n;
    static int arr[];

    public static void main(String[] args) throws Exception {
        /*
         * 카운팅 정렬 사용
         * 해당 위치의 빈도수가 0이 될때까지 i값 출력
         */
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        n = Integer.parseInt(br.readLine());

        arr = new int[10001];
        for (int i = 0; i < n; i++)  arr[Integer.parseInt(br.readLine())]++;
        
        for(int i=0;i<n;i++){
            while(arr[i]>0){
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
        
        br.close();
    }
}