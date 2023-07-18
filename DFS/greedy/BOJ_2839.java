package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_2839 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int minBonji = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		
		if(n%5 == 0) {
			minBonji = Math.min(minBonji, n/5);
		}
		if(n%3 == 0) {
			minBonji = Math.min(minBonji, n/3);
		}
		
		int a = n/5;
		int num = n%5;
		while(a>0) {
			if(num%3 == 0) {
				minBonji = Math.min(minBonji, a+num/3);
			}
			a--;
			num=n-5*a;
		}
		
		
		if(minBonji == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(minBonji);
		}
	}

}
