package com.day08.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_단지번호붙이기_DFS로풀기_2667 {
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int dirX[]= {1,0,-1,0};
	public static int dirY[]= {0,1,0,-1}, arr[][], count, n, num;
	public static boolean visit[][];
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
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
//					System.out.println(i+","+j);
					System.out.println("=======");
					count = 0;
					visit[i][j] = true;
					dfs(i, j);
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
	public static void dfs(int i, int j) {
		System.out.println(i+", "+j);
		visit[i][j] = true;
		count++;
		
		for(int dir = 0; dir<4; dir++) {
			int nx = i+dirX[dir];
			int ny = j+dirY[dir];
			
			
			if(nx<0 || nx>=n|| ny<0 || ny>=n) return;
			if(arr[nx][ny] == 1 && visit[nx][ny] == false) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
