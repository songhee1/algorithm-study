package com.edu.test;
import java.io.*;
import java.util.*;
public class 이코테_큰_수의_법칙 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static Integer arr[];
	public static int result[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int sum = 0;
		
		int a = m/(k+1);
		int b = m%(k+1);
		
		int result1 = a*arr[1] + a*(arr[0]*k);
		int result2 = b * arr[0];
		
		sum = result1 + result2;
		
		
		System.out.println(sum);
	}

}
