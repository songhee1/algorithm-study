package com.day08.graph;

import java.io.*;
import java.util.*;

public class BOJ_효율적인_해킹_1325 {
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static int count, ans[];
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			list.add(new ArrayList<>());
		}
		ans = new int[n+1];
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		
		int maxSum = 0;
		for(int i=1;i<n+1;i++) {
			visit = new boolean[n+1];
			q.add(i);
			bfs(i);
		}
		
		for(int i=1;i<n+1;i++) {
			if(maxSum<ans[i]) {
				maxSum = ans[i];
			}
		}
		
		for(int i=1;i<n+1;i++) {
			if(ans[i] == maxSum) {
				System.out.print(i+" ");
			}
		}
	
	}
	
	public static void bfs(int idx) {
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i=0;i<list.get(a).size();i++) {
				if(!visit[list.get(a).get(i)]) {
					q.add(list.get(a).get(i));
					ans[list.get(a).get(i)]++;
					visit[list.get(a).get(i)] = true;
				}
			}
		}
	}

}
