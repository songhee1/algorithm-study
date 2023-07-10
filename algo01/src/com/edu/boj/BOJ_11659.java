package com.edu.boj;
/*
 * n개가 주어졌을 때 i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하라
 * 
 * 입력
 * 1-수의 개수 n + 합을 구해야하는 횟수 m 
 * 2-n개의 수 (<=1000인 자연수)
 * 3~ 합을 구해야하는 구간 i j
 */
import java.io.*;
import java.util.*;
public class BOJ_11659 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int n, m, arr[], arr2[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int total = 0;
		for(int i=0;i<n;i++) {
			total += Integer.parseInt(st.nextToken());
			arr[i] = total;
		}
		
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			
			if(i != 0) {
				sb.append(arr[j]-arr[i-1]).append("\n");
			}else {
				sb.append(arr[j]).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
