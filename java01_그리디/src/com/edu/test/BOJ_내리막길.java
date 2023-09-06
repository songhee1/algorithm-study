package com.edu.test;

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
public class BOJ_내리막길{
	public static Queue<Pair> q = new LinkedList<>();
	public static int M, N, arr[][], dist[][];
	public static int cnum = 0, count = 0;
	public static StringBuilder sb = new StringBuilder();
	public static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		dist = new int[M][N];
	
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
	
		}
	
		find(0, 0);
		
		
		System.out.println(count);
			
	}

	public static void find(int x, int y) {
		

		for(int dir = 0;dir<4;dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
	
			if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
			if(arr[x][y] > arr[nx][ny]) {
				
				if(dist[x][y] == 0) {
					dist[nx][ny] = ++cnum;
				}else {
					dist[nx][ny] = dist[x][y];
				}
				
				if(nx == M-1 && ny == N-1) {
					count++;
					return;
				}
				find(nx, ny);
			}
			
		}
	}
}