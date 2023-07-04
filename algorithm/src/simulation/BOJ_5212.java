package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5212 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char arr[][];
	static int dist[][];
	static int row, col,rowMin= 11, colMin = 11, rowMax, colMax;
	static int dirX[]= {1,0,-1,0};
	static int dirY[]= {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();
	static Queue<Pair> queue = new LinkedList<>();
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new char[row][col];
		dist = new int[row][col];
		
		for(int i=0;i<row;i++) {
			String s = br.readLine();
			for(int j=0;j<col;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				dist[i][j] = -1;
			}
		}
		
		
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j] == 'X') {
					dist[i][j]=0;
					queue.add(new Pair(i,j));
					bfs();
					if(i==row-1 && j == 0) {
						dist[i][j]+=2;
					}else if(i==row-1 || j == col-1 || i == 0 || j==0) {
						dist[i][j]++;
					}else if(i==row-1 && j==col-1) {
						dist[i][j]+=2;
					}else if(i==0 && j == col-1) {
						dist[i][j]+=2;
					}else if(i==0 && j==0) {
						dist[i][j]+=2;
					}
					
					
					if(dist[i][j] <=2 && dist[i][j] != -1) {
						
					}else {
						arr[i][j] = '.';
					}
				}
			}
		}
		
		
		
		for(int i=rowMin;i<=rowMax;i++) {
			for(int j=colMin;j<=colMax;j++) {
				sb.append(arr[i][j]);
			}
		}
		
		System.out.println(sb);
		
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = now.x+dirX[dir];
				int ny = now.y+dirY[dir];
				
				if(nx<0 || nx>=row || ny<0  ||ny>=col) continue;
				if(arr[nx][ny] == '.') {
					dist[now.x][now.y]++;
					queue.add(new Pair(nx,ny));
				}
			}
		}
	}

}
