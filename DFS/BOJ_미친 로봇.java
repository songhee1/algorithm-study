import java.util.*;
import java.io.*;
class Solution{
	static double arr[];
	static double sum;
	static int n, x, y;
	static int dx[]= {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int v[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		v = new int[30][30];
		
		arr = new double[4];
		for(int i=0;i<4;i++) {
			arr[i] = Integer.parseInt(st.nextToken())/100.0;
		}
		v[15][15] = 1;
		dfs(0, 15, 15, 1);
		
		System.out.println(sum);
	}
	public static void dfs(int cnt, int x, int y, double gop) {
		if(cnt == n) {
			sum += gop;
			return;
		}
		
		for(int dir = 0;dir<4;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx<0 || nx>=30 || ny<0 || ny>=30) continue;
			if(v[nx][ny] == 0) {
				v[nx][ny] = 1;
//				System.out.println(cnt+1);
				dfs(cnt+1, nx, ny, gop*arr[dir]);
				v[nx][ny] = 0;
			}
		}
	}
}
