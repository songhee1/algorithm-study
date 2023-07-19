package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_DFS를_인접행렬로_구현_1260 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int matrix[][], n, m ,sn;
	public static boolean visit[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sn = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		dfs(sn, 1);
		
		System.out.println(sb);
	}
	public static void dfs(int idx, int count) {
		visit[idx] = true;
		sb.append(idx).append(" ");
		
		if(count == n) {
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<n+1;i++) {
			if(matrix[idx][i] == 1 && !visit[i]) {
				dfs(i, count+1);
			}
		}
	}

}
