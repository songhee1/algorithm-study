package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_DFS를_연결리스트로_구현_1260 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static List<Integer>[] list;
	public static int n, m, sn;
	public static boolean visit[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sn = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		visit = new boolean[n+1];
		for(int i=1;i<n+1;i++) {
			list[i] = new LinkedList();
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		visit[1] = true;
		dfs(1,1);
		
		System.out.println(sb);
		
	}
	public static void dfs(int idx, int count) {
		sb.append(idx).append(" ");
		if(count == n) {
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<list[idx].size();i++) {
			if(!visit[list[idx].get(i)]) {
				visit[list[idx].get(i)] = true;
				dfs(list[idx].get(i), count+1);
			}
		}
	}

}
