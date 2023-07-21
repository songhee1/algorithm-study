package com.day09.otherAlgo;
import java.io.*;
import java.util.*;

class Tree{
	int a;
	int b;
	Tree(int a, int b){
		this.a = a;
		this.b = b;
	}
}
public class BOJ_최소_스패닝_트리_1197 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int v, e, a, b, cost;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		Map<Integer, Tree> map = new HashMap<>();
		int costArr[] = new int [e];
		
		visit = new boolean[v+1];
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			cost = Integer.parseInt(st.nextToken());
			costArr[i] = cost;
			
			map.put(cost, new Tree(a,b));
			
		}
		
		Arrays.sort(costArr);
		int count = 0;
		for(int i=0;i<e;i++) {
			int findCost = costArr[i];
			Tree tree = map.get(findCost);
			if(!visit[tree.a] || !visit[tree.b]) {
				visit[tree.a] = true;
				visit[tree.b] = true;
				
				count+=findCost;
			}
		}
		
		
		System.out.println(count);
	}

}
