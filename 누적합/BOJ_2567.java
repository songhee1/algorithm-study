package com.day01.array;
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
public class BOJ_2567 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static boolean isvisited[][];
	public static int arr[][], count;
	public static int dirX[]= {1,0,-1,0};
	public static int dirY[]= {0,1,0,-1};
	public static Queue<Pair>q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[101][101];
		isvisited = new boolean [101][101];
		while(n-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
					}
				}
			}
			
		}
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(arr[i][j]==1) {
					for(int dir = 0;dir<4;dir++) {
						int nx = i+dirX[dir];
						int ny = j+dirY[dir];
						
						if(nx<0 || nx>100 || ny<0 || ny>100) continue;
						
						if(arr[nx][ny] == 0) {
							count++;
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
	

}
