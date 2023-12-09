import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], N, M, cityChicken = Integer.MAX_VALUE;
	static boolean v[];
	static List<Pair> list;
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		arr = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<N+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					list.add(new Pair(i, j));
				}
			}
		}
		v = new boolean[list.size()];
		
		find(0, new ArrayList<>(), 0);
		
		System.out.println(cityChicken);
	}
	public static void find(int cnt, List<Pair> chicken, int idx) {
		if(cnt >0 ) {
			int sum = 0;
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if(arr[i][j] == 1) {
						sum+= check(i, j, chicken);
					}
				}
			}
			cityChicken = Math.min(cityChicken, sum);
		}
		
		if(cnt == M) {
			return;
		}
		
		for(int i=idx;i<list.size();i++) {
			if(!v[i]) {
				v[i] = true;
				chicken.add(list.get(i));
				find(cnt+1, chicken, i+1);
				chicken.remove(chicken.size()-1);
				v[i] = false;
			}
		}
	}
	private static int check(int x, int y, List<Pair> chicken) {
		int sum = Integer.MAX_VALUE;
		for(int i=0;i<chicken.size();i++) {
		    int sub = 0;
		    sub += Math.abs(chicken.get(i).x - x);
		    sub += Math.abs(chicken.get(i).y - y);
		    if(sum> sub) {
		    	sum = sub;
		    }
		}
		
		return sum;
	}
	
}
