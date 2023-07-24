package com.day08.graph;
import java.io.*;
import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ_미로탐색_2178 {
	public static int dirX[]= {1,0,-1,0};
	public static int dirY[]= {0,1,0,-1};
	public static int arr[][], n, m, count, dist[][];
	public static Queue<Pair> q = new LinkedList<>();
	public static boolean visit[][];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		Scanner sc = new Scanner(System.in);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		for(int i=1;i<n+1;i++) {
			String s = br.readLine();
			for(int j=1;j<m+1;j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					q.add(new Pair(i,j));
					dist[i][j] = 1;
					bfs();
				}
			}
		}
		
		System.out.println(dist[n][m]);
		
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			for(int dir = 0;dir<4;dir++) {
				int nx = now.x+dirX[dir];
				int ny = now.y+dirY[dir];
				
				if(nx<=0 || nx>n || ny<=0 || ny>m) continue;
				if(arr[nx][ny] == 1 && !visit[nx][ny] && dist[nx][ny] == 0) {
					visit[nx][ny] = true;
					dist[nx][ny] = dist[now.x][now.y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

}
