package com.edu.test;

import java.io.*;
import java.util.*;
public class BOJ_주유소_13305 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static Long cost[], liter[], result[];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		cost = new Long[n];
		liter = new Long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<n;i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<n;i++) {
			liter[i] = Long.parseLong(st.nextToken());
		}
		st.nextToken();
		
		int posi = 1;
		long sum = cost[1] * liter[1];
		for(int i=2;i<n;i++) {
			if(liter[posi] * cost[i]< liter[i] * cost[i]) {
				sum += liter[posi] * cost[i];
			}else {
				sum += liter[i] * cost[i];
				posi = i;
			}
		}
		
		System.out.println(sum);
	}

}

