package com.edu.test;
import java.io.*;
import java.util.*;
class USADO{
	int node;
	int dist;
	USADO(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
}
public class BOJ_15591 {
	public static int n, q, k, v, count;
	public static boolean visit[];
	public static ArrayList<ArrayList> list = new ArrayList();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n+1;i++) {
			list.add(new ArrayList<USADO>());
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new USADO(b, dist));
			list.get(b).add(new USADO(a, dist));
			
		}
		
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			count = 0;
			find(k, a, Integer.MAX_VALUE, 0);
			sb.append(count).append("\n");
		}
		
		String s = sb.toString();
		if(s == "") {
			System.out.println(0);
		}else {
			System.out.println(s);
		}
	}
	
	public static void find(int k, int a, int min, int pre) {
		List<USADO> mList = list.get(a);
		
		for(int i=0;i<mList.size();i++) {
			USADO ud = mList.get(i);
			if(ud.node == pre) continue;
			int m = 0;
			if(ud.dist>min) {
				m = min;
			}else m = ud.dist;
			
			if(m >= k) {
				count++;
			}
			
			find(k, ud.node, m, a);
		}
	}

}
