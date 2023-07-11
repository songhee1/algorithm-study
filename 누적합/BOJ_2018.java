package com.day01.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2018 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int n, count;
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=i;j<=n;j++) {
				sum += j;
				if(sum == n) {
					count++;
				}else if(sum>n) {
					break;
				}
			}
			
		}
		
		System.out.println(count);

	}

}
