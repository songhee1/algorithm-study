package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_BFS를_연결리스트로_구현_1260 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, m, sn;
	public static boolean visit[];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sn = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) {
			list.add(new ArrayList());
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1;i<n+1;i++) {
			Collections.sort(list.get(i));
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
			
			for(int i=0;i<list.get(a).size();i++) {
				if(!visit[list.get(a).get(i)]) {
					q.add(list.get(a).get(i));
					visit[list.get(a).get(i)] = true;
				}
			}
		}
	}

}
