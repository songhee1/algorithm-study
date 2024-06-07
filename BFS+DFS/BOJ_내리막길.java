import java.io.*;
import java.util.*;
class Solution5 {
	static class Pair{
		int x;
		int y;
		int length;
		Pair(int x, int y, int length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	static int M, N, arr[][], x[] = {0,1,0}, y[]= {-1, 0, 1};
	static boolean visit[][];
	static int count;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();

    	st = new StringTokenizer(br.readLine());
    	
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	arr = new int[M][N];
    	visit = new boolean[M][N];
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dfsFind(new Pair(0,0,arr[0][0]));
    	System.out.println(count);
    }
	private static void dfsFind(Pair pair) {
		if(pair.x == M-1 && pair.y == N-1) {
			count++;
			return;
		}
		
		for(int i=0;i<x.length;i++) {
			int nx = pair.x+x[i];
			int ny = pair.y+y[i];
			if(nx<0 || ny<0 || nx>=M || ny>=N) {
				continue;
			}
			
			if(pair.length>arr[nx][ny]) {
				dfsFind(new Pair(nx, ny, arr[nx][ny]));
			}
		}
	}
	
	private static void find(Pair pair) {
		Queue<Pair> q = new LinkedList<>();
		q.add(pair);
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int i=0;i<x.length;i++) {
				int nx = now.x + x[i];
				int ny = now.y + y[i];
				if(nx<0 || nx>=M || ny<0 || ny>=N) {
					continue;
				}
				
				if(now.length <= arr[nx][ny]) {
					continue;
				}
				
				if(nx == M-1 && ny == N-1) {
					count++;
					continue;
				}
				
				q.add(new Pair(nx, ny, arr[nx][ny]));
				
			}
		}
	}
}
