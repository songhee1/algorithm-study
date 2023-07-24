package kruskal;
import java.io.*;
import java.util.*;
public class BOJ_불우이웃돕기_1414 {
	static class Comp implements Comparable<Comp>{
		int a;
		int b;
		int cost;
		Comp(int a, int b, int cost){
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Comp c) {
			return cost-c.cost;
		}
	}
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static char arr[][];
	public static int p[];
	public static List<Comp> list = new LinkedList<>();
	public static void main(String[] args)throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		arr = new char[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			String s = br.readLine();
			for(int j=1;j<n+1;j++) {
				arr[i][j] = s.charAt(j-1);
			}
		}  
		
		p = new int[n+1];
		for(int i=1;i<n+1;i++) {
			p[i] = i;
		}
		
		int total = 0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				
				if(arr[i][j]>='a' && arr[i][j]<='z') {
					total += arr[i][j] - 'a' + 1;
					list.add(new Comp(i, j , arr[i][j] - 'a' + 1));
				}else if(arr[i][j]>='A' && arr[i][j]<='Z') {
					total += arr[i][j] - 'A' + 27;
					list.add(new Comp(j,i, arr[i][j] - 'A' + 27));
				}
				
			}
		}
		
		Collections.sort(list);
		
		int size = list.size();
		int msum = 0;
		while(size-- >0) {
			Comp p = list.remove(0);
			
			if(find(p.a) == find(p.b)) continue;
			
			union(p.a, p.b);
			
			msum = p.cost;
		}
		
		if(msum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(total - msum);
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
		p[b] = a;
	}

}
