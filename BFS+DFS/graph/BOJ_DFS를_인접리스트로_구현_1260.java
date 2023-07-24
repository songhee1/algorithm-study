package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_DFS를_인접리스트로_구현_1260 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m ,sn;
	public static List<ArrayList<Integer>> list = new ArrayList<>();
	public static boolean visit[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sn = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) {
			list.add(new ArrayList<>());
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i=1;i<n+1;i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(sn);
		
		System.out.println(sb);
	}
	
	public static void dfs(int idx) {
		visit[idx] = true;
		sb.append(idx).append(" ");
		
		for(int i=0;i<list.get(idx).size();i++) {
			if(!visit[list.get(idx).get(i)]) {
			   dfs(list.get(idx).get(i));
			}
		}
	}

}
