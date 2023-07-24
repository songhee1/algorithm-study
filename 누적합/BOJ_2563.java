package com.day01.array;
/*
 * 가로, 세로 크기가 각각 100인 흰색 도화지
 * 가로 , 세로 크기가 각각 10인 검은 색종이를 평행하게 붙인다. 검은 영역의 넓이를 구하라
 * 
 * 입력
 * 1-색종이의 수
 * 2~ 색종이 위치 ( 1-색종이 왼쪽 변과 도화지 왼쪽 변 사이의 거리, 2- 색종이 아랫변과 도화지 
 * 아랫변 사이의 거리)
 * 
 * 
 */
import java.io.*;
import java.util.*;

public class BOJ_2563 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int num, pointX, pointY, count=0;
	public static int dirX[]= {1,0,-1,0};
	public static int dirY[]= {0,1,0,-1};
	public static int dist[][];
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		num = Integer.parseInt(br.readLine());
		
		dist = new int[102][102];
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				dist[i][j] = -1;
			}
		}
		while(num-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(dist[i][j] == -1) {
						count++;
						dist[i][j]=1;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
