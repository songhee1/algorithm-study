import java.util.*;
import java.io.*;
class Solution{
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1}, N, center; //농장크기, 중심 인덱스
	static int arr[][], sum;
	static boolean v[][], guide[][];
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=test_case;tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			v = new boolean[N][N];
			guide = new boolean[N][N];
			sum = 0;
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}
			
			center = (N-1)/2;
			
			if(N == 1) {
				sb.append("#"+tc+" ").append(arr[0][0]).append("\n");
				continue;
			}
			
			int y = center;
			int element = 0;
			
			for(int x=0;x<=center;x++, y--, element+=2) {
				guide[x][y] = true;
				guide[x][y + element] = true;
				if(element != 0)
					sum += arr[x][y] + arr[x][y+element];
				else 
					sum += arr[x][y];
				v[x][y] = v[x][y+element] = true;
			}
			
			y = center;
			element = 0;
			for(int x=N-1;x>center;x--, y--, element+=2) {
				guide[x][y] = true;
				guide[x][y + element] = true;
				if(element != 0)
					sum += arr[x][y] + arr[x][y+element];
				else 
					sum += arr[x][y];
				v[x][y] = v[x][y+element] = true;
			}
		
			
			findBox();
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(v[i][j]) System.out.print(1);
					else System.out.print(0);
				}
				System.out.println();
			}
			
			sb.append("#"+tc+" ").append(sum).append("\n");
			
		}
		
		System.out.print(sb);
	}
	public static void findBox() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(center, center));
		v[center][center] = true;
		sum += arr[center][center];
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			for(int dir = 0; dir<dx.length;dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(v[nx][ny] == false && guide[nx][ny] == false) {
					sum += arr[nx][ny];
					v[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}
	
}
