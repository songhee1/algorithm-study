package com.day09.otherAlgo;
import java.io.*;
import java.util.*;
public class BOJ_여행가자_1976 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int n, m, arr[][], city[], p[];
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		p = new int[n+1];
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				union(i,j);
			}
		}
		
		for(int i=1;i<n+1;i++) {
			p[i] = i;
		}
		
		List<Integer> list = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int pre = 0;
		for(int i = 0;i<list.size()-1;i++) {
			int a = list.get(i);
			int b = list.get(i+1);
			
			boolean flag = union(a,b);
			
		}
		
		System.out.println("YES");
		
		
	}
	
	public static boolean union(int a, int b) {
		if(find(a) == find(b)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int find(int n) {
		if(n == p[n]) return n;
		return p[n] = find(p[n]);
	}

}
