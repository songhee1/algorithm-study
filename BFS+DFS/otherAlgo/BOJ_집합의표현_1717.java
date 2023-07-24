package com.day09.otherAlgo;
import java.io.*;
import java.util.*;
public class BOJ_집합의표현_1717 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int n, m, idx, a, b, p[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			p[i] = i;
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			idx = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(idx == 0) {
				union(a,b);
			}else {
				if(find(a) == find(b)){
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	public static void union(int a, int b) {
		p[find(b)] = p[find(a)];
	}
	
	public static int find(int n) {
		if(n == p[n]) {
			return n;
		}
		return p[n] = find(p[n]);
	}

}
