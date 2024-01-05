import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], maxA, maxB;
	static long d[][];
	static int sx, sy, ex, ey;
	static int dx[] = {1, 1, 0, 0, -1, -1};
	static int dy[] = {0, 1, -1, 1, -1, 0};
	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		set();
		arr = new int[maxA+1][maxB+1];
		setArr();
		d = new long[maxA+1][maxB+1];
		
		for(int test_case=1;test_case<=t;test_case++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(s == e) {
				sb.append("#"+test_case+" ").append(0).append("\n");
				continue;
			}
			
			for(int i=0;i<maxA+1;i++) {
				for(int j=0;j<maxB+1;j++) {
					d[i][j] = -1;
				}
			}
			
			findxy(s, e);
		
			sb.append("#"+test_case+" ").append(find()).append("\n");
	
		}
		System.out.println(sb);
	}
	private static void setArr() {
		int start = 1;
		for(int i=0;;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j] = start++;
				if(i == maxA && j == maxB) return;
			}
		}
	}
	private static long find() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sx, sy));
		d[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int dir = 0;dir<dx.length;dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				
				if(!checkRange(nx, ny)) continue;
				if(nx == ex && ny == ey) {
					return d[now.x][now.y]+1;
				}
				if(d[nx][ny] != -1 || d[nx][ny] >= 0) continue;
				
				d[nx][ny] = d[now.x][now.y] + 1;
				q.add(new Pair(nx, ny));
			}
		}
		
		return 1;
	}
	private static boolean checkRange(int nx, int ny) {
		if(nx <0 || nx>maxA || ny<0 || ny>maxB) return false;
		else if(arr[nx][ny] == 0) return false;
		return true;
	}
	private static void findxy(int s, int e) {
		boolean findS = false; boolean findE = false;
		for(int i=0;i<maxA+1;i++) {
			for(int j=0;j<maxB+1;j++) {
				if(arr[i][j] == 0 )continue;
				if(arr[i][j] == s) {
					sx = i; sy = j;
					findS = true;
				}else if(arr[i][j] == e) {
					ex = i; ey = j;
					findE = true;
				}
				if(findS && findE) return;
			}
		}
	}
	public static void set() {
		int start = 1;
		for(int i=0;;i++) {
			for(int j=0;j<=i;j++) {
				start++;
				maxA = Math.max(maxA, i);
				maxB = Math.max(maxB, j);
				if(start > 11000) {
					return;
				}
			}
		}
	}
	
}
