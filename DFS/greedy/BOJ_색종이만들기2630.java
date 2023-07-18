package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_색종이만들기2630 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[][], blueNum, whiteNum;
	public static void main(String[] args) throws Exception {
		int size = Integer.parseInt(br.readLine());
		
		arr = new int[size][size];
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp(0,0,size);
		
		System.out.println(whiteNum);
		System.out.println(blueNum);
	}
	
	public static void dp(int startX, int startY, int size) {
		if(check(startX, startY, size) && arr[startX][startY] == 1) {
			blueNum++;
			return;
		}else if(check(startX, startY, size) && arr[startX][startY] == 0) {
			whiteNum++;
			return;
		}
		
		dp(startX, startY, size/2);
		dp(startX, startY+size/2, size/2);
		dp(startX+size/2, startY,  size/2);
		dp(startX+size/2, startY+size/2, size/2);
	}
	
	public static boolean check(int startX, int startY, int size) {
		for(int i=startX;i<startX+size;i++) {
			for(int j=startY;j<startY+size;j++) {
				if(arr[i][j]!=arr[startX][startY]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
