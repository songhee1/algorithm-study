package com.day06.greedy;
import java.io.*;
import java.util.*;
public class SWEA_최소생산비용5209 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[][], minNum = Integer.MAX_VALUE, num, col[], row[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<tc+1;i++) {
			num = Integer.parseInt(br.readLine());
			
			arr = new int[num][num];
			minNum = Integer.MAX_VALUE;
			col = new int[num];
			row = new int[num];
			for(int j=0;j<num;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<num;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp(0, 0);
			
			sb.append("#"+i).append(" ").append(minNum).append("\n");
			
		}
		
		System.out.println(sb);
	}
	public static void dp(int count, int sum) {
        if(sum>minNum) {
            return;
        }
        
		if(count == num) {
			minNum = Math.min(minNum, sum);
			return;
		}
		
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				if(col[i] == 0 && row[j] == 0) {
					col[i] = 1; row[j] = 1;
					dp(count+1, sum+arr[i][j]);
					col[i] = 0; row[j] = 0;
				}
			}
		}
		
	}

}
