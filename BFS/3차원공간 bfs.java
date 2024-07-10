import java.io.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;
class Solution5 {
	static StringBuilder sb = new StringBuilder();
	static int M, N, H, totalTimes;
	static int arr[][][];
	static class Pair{
		int h;
		int x;
		int y;
		Pair(int h, int x, int y){
			this.h=h;
			this.x=x;
			this.y=y;
		}
	}
	static int dh[]= {1,-1,0,0,0,0};
	static int dx[]= {0,0,0,0,-1,1};
	static int dy[]= {0,0,-1,1,0,0};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	arr = new int[H][M][N];
    	Queue<Pair> q = new LinkedList<>();
    	for(int height=0;height<H;height++){
    		for(int i=0;i<M;i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
    				arr[height][i][j] = Integer.parseInt(st.nextToken());
    				if(arr[height][i][j] == 1) {
    					q.add(new Pair(height, i, j));
    				}
    			}
    		}
    	}
    	
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nh = now.h+dh[dir];
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				if(nh<0 || nh>=H ||nx<0||nx>=M||ny<0||ny>=N) continue;
				if(arr[nh][nx][ny] == 0) {
					arr[nh][nx][ny] = arr[now.h][now.x][now.y]+1;
					q.add(new Pair(nh, nx, ny));
				}
			}
		}
		
    
    	for(int height=0;height<H;height++){
    		for(int i=0;i<M;i++) {
    			for(int j=0;j<N;j++) {
    				if(arr[height][i][j] == 0) {
    					System.out.println(-1);
    					return;
    				}else{
    					totalTimes = Math.max(totalTimes, arr[height][i][j]);
    				}
    			}
    		}
    	}
    	
    	if(totalTimes == 0) {
    		System.out.println(0);
    	}else {
    		System.out.println(totalTimes-1);
    	}
    	
	}
	
}
