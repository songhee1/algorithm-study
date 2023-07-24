package com.day09.otherAlgo;
import java.io.*;
import java.util.*;
public class BOJ_연결요소의_개수_11724 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int p[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		for(int i=1;i<n+1;i++) {
			p[i]= i;
		}
		
		for(int i=0;i<v;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		for(int i=1;i<n+1;i++) {
			find(i);
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<n+1;i++) {
			set.add(p[i]);
		}
		
		System.out.println(set.size());
	}
	
	public static void union(int a, int b) {
		if(p[find(a)] == p[find(b)]) return;
		
		p[find(b)] = p[find(a)];
	}
	
	public static int find(int n) {
		if(n == p[n]) return n;
		return p[n] = find(p[n]);
	}

}
