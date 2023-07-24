package kruskal;
import java.io.*;
import java.util.*;
public class BOJ_도시분할계획_1647 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static List<Edge> q = new LinkedList<>();
	public static boolean visit[];
	public static int p[], v, e, minSum, edgeNum;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		p = new int[v+1];
		for(int i=1;i<v+1;i++) {
			p[i] = i;
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int cost = Integer.parseInt(st.nextToken());
			
			q.add(new Edge(a, b, cost));
		}
		
		Collections.sort(q);
		edgeNum = q.size();
		int lastSize = 0;
		
		while(edgeNum-- >0) {
			Edge e = q.remove(0);
			
			if(find(e.a) == find(e.b)) continue;
			
			union(e.a, e.b);
			minSum += e.cost;
			
			lastSize = Math.max(lastSize, (int)e.cost);
		}
		
		System.out.println(minSum - lastSize);
		
	}
	public static int find(int n) {
		if(n == p[n]) return n;
		return p[n] = find(p[n]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		p[find(b)] = a;
	}
	

}
