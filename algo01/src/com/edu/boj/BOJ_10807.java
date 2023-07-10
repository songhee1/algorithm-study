package com.edu.boj;
/*
 * 총 n개 정수가 주어졌을 때 정수 v가 몇 개인지 구하는 프로그램 작성
 * 
 * 입력
 * 1-정수의 개수 n(1<=n<=100)
 * 2-정수가 공백으로 구분
 * 3-찾으려는 정수v가 주어진다
 * 
 * -100<= 정수와 v <=100
 * 
 * 출력
 * n개의 정수 중 v가 몇 개인지 구하라
 */
import java.io.*;
import java.util.*;
public class BOJ_10807 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, v, arr[];
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[201];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[Integer.parseInt(st.nextToken())+100]++;
		}
		
		v = Integer.parseInt(br.readLine());
		System.out.print(arr[v+100]);
	}

}
