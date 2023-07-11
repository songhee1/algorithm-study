package com.day01.array;
import java.io.*;
import java.util.*;
public class SW_12712 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int tc, n, m, arr[][];
	public static int plusX[]= {-1, 0, 1, 0};
	public static int plusY[]= {0, 1, 0,-1};
	public static int axX[]= {-1, 1, 1, -1};
	public static int axY[]= {1, 1, -1,-1};
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<tc+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			//nxn 배열 크기 설정
			n = Integer.parseInt(br.readLine());
			//스프레이 세기 크기 설정
			m = Integer.parseInt(br.readLine());
			
			arr = new int [n][n];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxNum = 0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					int plusTotal = 0;
					for(int dp = 0;dp<4;dp++) {
						plusTotal+=arr[j][k];
					}
				}
			}
		}
	}

}
