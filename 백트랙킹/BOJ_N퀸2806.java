package com.day07.backtracking;
import java.io.*;

public class BOJ_N퀸2806 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int col[], row[], left[], right[], n, num;
	public static void main(String[] args) throws Exception  {
		n = Integer.parseInt(br.readLine());
		
		col = new int[n];
		row = new int[n];
		
		left = new int[2*n+1];
		right = new int[2*n+1];
		
		dfs(0, 0);
		
		System.out.println(num);
	}
	
	public static void dfs(int count, int idx) {
		if(count == n) {
			num++;
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(col[idx] == 0 && row[i] ==0 && left[(idx-i)+(n-1)] == 0 && right[idx+i] == 0) {
				col[idx] = 1;
				row[i] = 1;
				left[(idx-i)+(n-1)] = 1;
				right[idx+i] = 1;
				dfs(count+1, idx+1);
			    
				col[idx] = 0;
				row[i] = 0;
				left[(idx-i)+(n-1)] = 0;
				right[idx+i] = 0;
			}
		}
		
	}

}
