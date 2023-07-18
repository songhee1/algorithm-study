package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_18429 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[], num, n, k, anw[];
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		visit = new boolean[n];
		arr = new int[n];
		anw = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp(0, 500);
		
		System.out.println(num);
	}
	
	public static void dp(int day, int kg) {
		if(kg<500) {
			return;
		}
		
		if(day == n) {
			if(kg>=500) {
				num++;
			}
			return;
		}
	
		
		for(int i=0;i<arr.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dp(day+1, kg-k+arr[i]);
				visit[i] = false;
			}
		}
	}

}
