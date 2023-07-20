package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_케빈베이컨의_6단계_법칙_1389 {
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static List<Integer>[] list;
	public static Queue<Integer> q = new LinkedList<>();
	public static int n, m, dp[], count;
	public static boolean visit[];
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new LinkedList<>();
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		int sum = Integer.MAX_VALUE; int minPerson = 0;
		List<Integer> sameNumber = new ArrayList<>();
		
		for(int i=1;i<n+1;i++) {
			dp = new int[n+1];
			visit = new boolean[n+1];
			dp[i] = 0;
			visit[i] = true;
			q.add(i);
			bfs();
			
			int total = 0;
			for(int a : dp) {
				total += a;
			}
			
			if(sum>total) {
				sum = total;
				minPerson = i;
				sameNumber.clear();
				sameNumber.add(i);
			}else if (sum == total){
				sameNumber.add(i);
			}
		}
		
		Collections.sort(sameNumber);
		System.out.println(sameNumber.get(0));
		
		
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i=0;i<list[a].size();i++) {
				if(!visit[list[a].get(i)] || (visit[list[a].get(i)]== true && dp[list[a].get(i)]>dp[a]+1)) {
					visit[list[a].get(i)] = true;
					q.add(list[a].get(i));
					dp[list[a].get(i)] = dp[a]+1;
				}
			}
		}
	}

}
