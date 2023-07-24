package kruskal;
import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge>{
	int a;
	int b;
	long cost;
	
	@Override
	public int compareTo(Edge e) {
		return (int)(cost - e.cost);
	}
	
	Edge(int a, int b, long cost){
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	
}

public class BOJ_최소스패닝트리_1197 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static List <Edge> edgeArr = new ArrayList<>();
	public static int v, e, p[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		p = new int[v+1];
		
		initP();
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			
			edgeArr.add(new Edge(a, b, cost));
			
		}
		
		Collections.sort(edgeArr);
		
		int edgeNum = edgeArr.size();
		long sumCost = 0;
		
		while(edgeNum-- >0) {
			Edge e = edgeArr.remove(0);
			if(find(e.a) != find(e.b)) {
				union(e.a, e.b);
				sumCost += e.cost;
			}
			
		}
		
		System.out.println(sumCost);
	}
	public static void initP() {
		for(int i=1;i<v+1;i++) {
			p[i] = i;
		}
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
