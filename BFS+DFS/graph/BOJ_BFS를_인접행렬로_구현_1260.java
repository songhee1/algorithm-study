package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_BFS를_인접행렬로_구현_1260 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m, sn, arr[][];
	public static boolean visit[];
	public static Queue<Integer> q = new LinkedList<>();
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sn = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		arr = new int[n+1][n+1];
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		visit[sn] = true;
		q.add(sn);
		bfs();
		
		System.out.println(sb);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(" ");
			
			for(int i=1;i<n+1;i++) {
				if(arr[a][i] == 1 && !visit[i]) {
				   q.add(i);
				   visit[i] = true;
				}
			}
		}
	}

}
