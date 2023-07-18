package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_장훈이의선반 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int tc, n, b, arr[], minCha = Integer.MAX_VALUE;
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<tc+1;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			minCha = Integer.MAX_VALUE;
			dp(0, 0);
			
			System.out.println("#"+i+" "+minCha);
		}
		
		
	}
	public static void dp(int count, int sum) {
		if(count == n) {
			if(sum>=b) {
				minCha = Math.min(minCha, sum-b);
			}
			return;
		}
		
		dp(count+1, sum+arr[count]);
		dp(count+1, sum);
	}

}
