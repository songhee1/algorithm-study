package com.edu.test;
import java.io.*;
import java.util.*;
class Dots{
	int x;
	int y;
	Dots(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class BOJ_21610 {
	public static boolean visit[][];
	public static int arr[][], past[][];;
	public static int dirX[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static int dirY[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Dots> q =new LinkedList<>(); 
		
		arr = new int[n][n];
		past = new int[n][n];
	
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new Dots(n-2, 0));
		q.add(new Dots(n-2, 1));
		q.add(new Dots(n-1, 0));
		q.add(new Dots(n-1, 1));
		
		int sum = 0;
		
	    for(int i=0;i<m;i++) {

	    	visit = new boolean[n][n];
	    	
	    	st = new StringTokenizer(br.readLine());
	    	int d = Integer.parseInt(st.nextToken());
	    	int s = Integer.parseInt(st.nextToken());
	    	int nx = 0;
	    	int ny = 0;
	    	int size = q.size();
	    	past = arr.clone();
	    	
	    	for(int j = 0;j<size;j++) {
	    		int num = 0; 
	    		int count = 0;
	    		Dots dot = q.poll();
	    		nx = dot.x;
	    		ny = dot.y;
	    		
	    		
	    		while(count != s) {
	    			count++;
		    		nx += dirX[d];
		    		ny += dirY[d];
		    		
		    		
		    		if(nx>=n) nx = 0;
		    		else if(nx<0) nx = n-1;
		    		
		    		if(ny>=n) ny = 0;
		    		else if(ny<0) ny = n-1;

	    		}
	    		
	    		
	    		
	    		if(nx == 0) {
	    			if(ny == 0) {
	    				if(past[nx+1][ny+1] >= 1) num++;
	    			}else if(ny >0 && ny<n-1) {
	    				if(past[nx+1][ny+1] >= 1) num++;
	    				if(past[nx+1][ny-1] >= 1) num++;
	    			}else if(ny == n-1) {
	    				if(past[nx+1][ny-1] >= 1) num++;
	    			}
	    		}else if(nx>0 && nx<n-1) {
	    			if(ny == 0) {
	    				if(past[nx+1][ny+1] >= 1) num++;
	    				if(past[nx-1][ny+1] >= 1) num++;
	    			}else if(ny >0 && ny<n-1) {
	    				if(past[nx+1][ny+1] >= 1) num++;
	    				if(past[nx+1][ny-1] >= 1) num++;
	    				if(past[nx-1][ny+1] >= 1) num++;
	    				if(past[nx-1][ny-1] >= 1) num++;
	    			}else if(ny == n-1) {
	    				if(past[nx+1][ny-1] >= 1) num++;
	    				if(past[nx-1][ny-1] >= 1) num++;
	    			}
	    		}else if(nx == n-1) {
	    			if(ny == 0) {
	    				if(past[nx-1][ny+1] >= 1) num++;
	    			}else if(ny >0 && ny<n-1) {
	    				if(past[nx-1][ny+1] >= 1) num++;
	    				if(past[nx-1][ny-1] >= 1) num++;
	    			}else if(ny == n-1) {
	    				if(past[nx-1][ny-1] >= 1) num++;
	    			}
	    		}
	    		arr[nx][ny] += num;
	    	}//두번째 for문
	    	
	    	
	    	for(int j=0;j<n;j++) {
	    		for(int k=0;k<n;k++) {
	    			if(visit[j][k] == false && arr[j][k] >=2) {
	    				arr[j][k] -=2;
	    				q.add(new Dots(j, k));
	    				
	    			}
	    		}
	    	}
	    	
	    }
	    
		for(int j=0;j<n;j++) {
    		for(int k=0;k<n;k++) {
    			
					sum += arr[j][k];
				
    		}
    	}
	    
	    System.out.println(sum);
	}

}
