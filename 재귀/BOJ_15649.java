package com.other.fullfind;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int arr[], n, k, anw[], idx;
	public static boolean isvisited[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k =Integer.parseInt(st.nextToken());
		isvisited = new boolean[n+1];
		
		anw = new int [k];
		arr = new int [n+1];
		
		for(int i=1;i<n+1;i++) {
			arr[i] = i;
		}
		
		
		make_sort(0,0,0);
		
		System.out.println(sb);
		
	}public static void make_sort(int count, int i, int idx) {
		if(count == k) {
			for(int j=0;j<anw.length;j++) {
				sb.append(anw[j]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int j=1; j<=n;j++) {
			if(isvisited[j] == false) {
				isvisited[j] = true;
				anw[idx] = j;
				make_sort(count+1, j, idx+1);
				isvisited[j] = false;
				anw[idx] = 0;
				
			}
		}
	}

}
