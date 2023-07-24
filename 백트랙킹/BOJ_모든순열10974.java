package com.day07.backtracking;
import java.io.*;
import java.util.*;
public class BOJ_모든순열10974 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[], n, anw[];
	public static StringBuilder sb = new StringBuilder();
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n+1];
		anw = new int[n+1];
		arr = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			arr[i] = i;
		}
		
		dfs(0, 1);
		
		System.out.println(sb);
	}
	public static void dfs(int count, int idx) {
		if(count == n) {
			for(int i=1;i<n+1;i++) {
				sb.append(anw[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				visit[i] = true;
				anw[idx] = i;
				dfs(count+1, idx+1);
				visit[i] = false;
			}
		}
	}

}
