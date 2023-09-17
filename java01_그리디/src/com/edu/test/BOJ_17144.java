package com.edu.test;
import java.io.*;
import java.util.*;
class Dust{
	int x;
	int y;
	Dust(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class BOJ_17144 {
	public static int arr[][], sumDusts, cleaner = -1;
	public static int R, C, T;
	public static int dirX[] = {1,0,-1,0}, dirY[]= {0,1,0,-1};
	public static Queue<Dust> dust;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1 && cleaner == -1) {
					cleaner = i;
				}
			}
		}
		
		for(int i=0;i<T;i++) {
		
			findDusts();
			
			spread();
			
			move();
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] == -1) continue;
				sumDusts += arr[i][j];
			}
		}
		
		System.out.println(sumDusts);
	}
	
	public static void findDusts() {
		dust = new LinkedList();
		 for(int i=0;i<R;i++) {
			 for(int j=0;j<C;j++) {
				 if(arr[i][j] == -1 || arr[i][j] == 0) continue;
				 dust.add(new Dust(i, j));
			 }
		 }
	}
	
	public static void spread() {
		while(!dust.isEmpty()) {
			Dust d = dust.poll();
			int spreadAmount = arr[d.x][d.y]/5;
			if(arr[d.x][d.y] <5) continue;
			int canSpreadNum = 0;
			for(int dir=0;dir<4;dir++) {
				int nx = d.x+dirX[dir];
				int ny = d.y+dirY[dir];
				
				if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
				if(arr[nx][ny] == -1) continue;
				canSpreadNum++;
				arr[nx][ny] += spreadAmount;
			}
			
			arr[d.x][d.y] = arr[d.x][d.y] - spreadAmount*canSpreadNum;
		}
	}
	
	public static void move() {
		int upCleaner = cleaner;
		int downCleaner = cleaner+1;
		
		//아래로 당겨온다.
		for(int i=upCleaner-1;i>0;i--) {
			arr[i][0] = arr[i-1][0];
		}
		
		//왼쪽으로 당겨준다;
		for(int i=0;i<C-1;i++) {
			arr[0][i] = arr[0][i+1];
		}
		
		
		//위로 당겨준다.
		for(int i=0;i<upCleaner;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		
		
		//오른쪽으로 당겨준다
		for(int i=C-1;i>1;i--) {
			arr[upCleaner][i] = arr[upCleaner][i-1];
		}
		
		arr[upCleaner][1] = 0;
		
		//오른쪽으로 당겨준다
		for(int i=C-1;i>1;i--) {
			arr[downCleaner][i] = arr[downCleaner][i-1];
		}
		
		//아래로 당겨준다.
		for(int i=R-1;i>downCleaner;i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		
		//왼쪽으로 당겨준다.
		for(int i=0;i<C-1;i++) {
			arr[R-1][i] = arr[R-1][i+1];
		}
		
		//위로 당겨준다.
		for(int i=downCleaner+1;i<R-1;i++) {
			arr[i][0] = arr[i+1][0];
		}
		
		arr[downCleaner][1] = 0;
		
		
	}
	
}
