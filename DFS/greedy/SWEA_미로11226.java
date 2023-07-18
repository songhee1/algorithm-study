package com.day06.greedy;
import java.io.*;
import java.util.*;
public class SWEA_미로11226 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static long arr[][], answer =0;
	public static int dirX[]= {0,1,0,-1}, dirY[]= {1,0,-1,0};
	public static boolean visit[][];
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<10+1;i++) {
			arr = new long[16][16];
			visit = new boolean[16][16];
			
			for(int j=0;j<16;j++) {
				String []strArr = sc.next().split("");
				for(int k=0;k<16;k++) {
					arr[j][k] = Long.parseLong(strArr[k]);
				}
			}
			
			for(int j=0;j<16;j++) {
				for(int k=0;k<16;k++) {
					System.out.print(arr[j][k]);
				}
				System.out.println();
			}
			
			answer = 0;
			visit[1][1] = true;
			dfs(1,1);
			
			System.out.println("#"+i+" "+answer);
		}
	}
	public static void dfs(int i, int j) {
		
		
		if(i==13 && j == 13 && arr[i][j] == 3) {
			answer = 1;
			return;
		}
		
		for(int dir = 0; dir<4;dir++) {
			int nx = i+dirX[dir];
			int ny = j+dirY[dir];
			
			if(nx<0 || nx>=16|| ny<0 || ny>=16) return;
			if(visit[nx][ny] == false) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
