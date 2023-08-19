package com.edu.test;

import java.io.*;
import java.util.*;
public class 이코테_숫자_카드_게임 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		int totalMax = 1;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int minNum = 10000;
			for(int j=0;j<m;j++) {
				minNum = Math.min(minNum, Integer.parseInt(st.nextToken()));
			}
			totalMax = Math.max(totalMax, minNum);
		}
		
		System.out.println(totalMax);
	}

}
