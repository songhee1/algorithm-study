package com.day08.graph;
import java.io.*;
import java.util.*;
public class BOJ_단지번호붙이기2667 {
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int dirX[]= {1,0,-1,0};
	public static int dirY[]= {0,1,0,-1}, arr[][], count, n, num;
	public static boolean visit[][];
	public static List<Integer> list = new ArrayList<>();
	public static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		arr = new int [n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					num++;
					count = 0;
					q.add(new Pair(i,j));
					visit[i][j] = true;
					bfs();
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(num);
		for(int a : list) {
			System.out.println(a);
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			count++;
			
			for(int dir = 0; dir<4; dir++) {
				int nx = p.x+dirX[dir];
				int ny = p.y+dirY[dir];
				
				if(nx<0||nx>=n||ny<0||ny>=n) continue;
				if(!visit[nx][ny] && arr[nx][ny] == 1) {
					visit[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

}
