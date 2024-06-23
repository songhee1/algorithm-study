import java.io.*;
import java.util.*;
class Main {
	static class Tetromino{
		int a;
		int b;
		Tetromino(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	static int N, M, maxSum = 0;
	static int arr[][], dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	visit = new boolean[N][M];
        
    	arr = new int[N][M];
    	
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			visit[i][j] = true;
    			DFS(i, j, 2, arr[i][j]);
    			visit[i][j] = false;
    		}
    	}
    	
    	System.out.println(maxSum);
	}
	private static void DFS(int x, int y, int num, int sum) {
		if(num == 5) {
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		for(int i=0;i<dx.length;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(visit[nx][ny] == true) continue;
			visit[nx][ny] = true;
			
			if(num == 3) {
				DFS(x, y, num+1, sum + arr[nx][ny]);
			}
			DFS(nx, ny, num+1, sum + arr[nx][ny]);
			visit[nx][ny] = false;
		}
	}
	
}
