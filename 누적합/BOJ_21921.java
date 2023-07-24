package com.day01.array;
import java.io.*;
import java.util.*;
/*
 * X일동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
 * x일 간 가장 많이 들어온 방문자 수와 기간이 몇 개 인지 구해주자
 * 
 * 입력
 * 1-블로그 시작하고 지난 일수 n, x
 * 2-블로그 시작 1일차부터 n일차 까지 하루 방문자 수
 * 
 * 출력
 * 1- x일 간 가장 많이 들어온 방문자수 출력
 * 2- 최대 방문자 수가 0명이 아닌 경우 기간이 몇 개인지 출력
 * (0명이면 SAD 출력) 
 */
public class BOJ_21921 {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int n, x, count;
	public static int arr[];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxNum = 0, sum = 0;
		for(int i=0;i<x;i++) {
			sum +=arr[i];
		}
		count = 1;
		maxNum = Math.max(maxNum, sum);
		
		int pre = 0, next = 0;
		for(int i=1;i<n-x+1;i++) {
			pre = i-1;
			next = i+(x-1);
			sum -= arr[pre];
			sum += arr[next];
			if(maxNum < sum) {
				maxNum = sum;
				count = 1;
			}else if(maxNum == sum) {
				count++;
			}
		}
		
		if(maxNum == 0) {
			sb.append("SAD");
		}else {
			sb.append(maxNum).append("\n");
			sb.append(count);
		}
		
		System.out.println(sb);
		
		
	}

}
