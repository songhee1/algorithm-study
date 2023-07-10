package com.edu.boj;
import java.io.*;
import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class SW_1210 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int dirX[]= {-1, 1, 0};
	public static int dirY[]= {0, 0, -1};
	public static int arr[][];
	public static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		int testcase = 10;
		
		for(int i=1;i<testcase+1;i++) {
			arr = new int[100][100];
			int a = Integer.parseInt(br.readLine());
			
			for(int j=0;j<100;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<100;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			run(i);
			
		}
		System.out.println(sb);
	}
	public static boolean bfs() {
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			for(int dir = 0;dir<3;dir++) {
				int nx = now.x+dirX[dir];
				int ny = now.y+dirY[dir];
				
				if(nx<0 || nx>=100 || ny<0 || ny>=100) {
					break;
				}
				if(arr[nx][ny] == 1) {
					if(ny == 0) return true;
					q.add(new Pair(nx, ny));
				}
			}
		}
		
		return false;
	}
	public static void run(int testcase) {
			for(int j=0;j<100;j++) {
				if(arr[99][j] == 2) {
					q.add(new Pair(100,j));
					boolean flag = bfs();
					if(flag == true) {
						sb.append("#"+testcase+" "+j).append("\n");
						return;
					}
				}
		}
	}
}
