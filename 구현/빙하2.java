import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Main {
	static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	static int dx[] = {0,0,-1,1}, dy[] = {1,-1,0,0};
	static int arr[][], N, M, time = 0, newArr[][];
	static boolean visit[][];
	static boolean allWater;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	IceMelting();
    	System.out.println(time);
    	
    	//갯수를 세었을때 2개 미만이면 0출력
	}
	private static void IceMelting() {
		int iceNums = 0;
		while((iceNums = bfs())<2) {
			if(iceNums == 0) {
				time = 0;
				return;
			}
			visit = new boolean[N][M];
			time++;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j] != 0 && visit[i][j] == false) {
						visit[i][j] = true;
						checkAroundZero(i, j);
					}
				}
			}
			
			
		}
		
	}
	private static int bfs() {
		int cnt = 0;
		boolean check[][] = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] != 0 && check[i][j] == false) {
					findIce(i, j, check);
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void findIce(int i, int j, boolean check[][]) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(i, j));
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			XY now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(arr[nx][ny] != 0 && check[nx][ny] == false) {
					check[nx][ny] = true;
					q.add(new XY(nx, ny));
				}
			}
		}
	}
	private static void checkAroundZero(int x, int y) {
		int num = 0;
		for(int dir=0;dir<dx.length;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			if(arr[nx][ny] == 0 && visit[nx][ny] == false) {
				num++;
			}
		}
		if(arr[x][y]<num) {
			arr[x][y] = 0;
		}else {
			arr[x][y]-=num;
		}
	}
	
}
