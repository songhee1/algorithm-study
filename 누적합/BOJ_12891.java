package com.day01.array;

import java.io.*;
import java.util.*;
/*
 * DNA 문자열 = {'A','C','G','T'}인 물자열
 * 
 * 각각 몇 번 등장해야 부분 문자열 비밀번호로 사용할 수 있는지 주어질 때 만들 수 있는 비밀번호 종류의 수를 구하는
 * 프로그램을 구하라
 * 
 * 부분 문자열 이 등장하는 위치가 다르면 같더라도 다른 문자열로 취급한다.
 * 
 * 입력
 * DNA 길이 S + 부분 문자열의 길이 P (1<=P, S<=1,000,000)
 * 임의로 만든 DNA  문자열
 * 부분 문자열에 포함되어야 할 A,C,G,T의 최소 개수 제시
 */
public class BOJ_12891 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static String original, made;
	public static int n,m, a,c,g,t, startIdx, endIdx, count;
	public static StringTokenizer st;
	public static void main(String[] args)throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		original = br.readLine();
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		g=Integer.parseInt(st.nextToken());
		t =Integer.parseInt(st.nextToken());
		
		int a1 = 0, c1=0, g1=0, t1=0;
		int pre = 0, next = 0;
		for(int i=0;i<=m-1;i++) {
			if(original.charAt(i) == 'A') {
				a1++;
			}else if(original.charAt(i) == 'C') {
				c1++;
			}else if(original.charAt(i) == 'G') {
				g1++;
			}else if(original.charAt(i) == 'T') {
				t1++;
			}
		}
		if(a1>=a && c1>=c && g1>=g && t1>=t) {
			count++;
		}
		
		
		for(int i=startIdx+1;i<=n-1-(m-1);i++) {
			pre = i-1;
			if(original.charAt(pre) == 'A') {
				a1--;
			}else if(original.charAt(pre) == 'C') {
				c1--;
			}else if(original.charAt(pre) == 'G') {
				g1--;
			}else if(original.charAt(pre) == 'T') {
				t1--;
			}
			
			next = i+(m-1);
			if(original.charAt(next) == 'A') {
				a1++;
			}else if(original.charAt(next) == 'C') {
				c1++;
			}else if(original.charAt(next) == 'G') {
				g1++;
			}else if(original.charAt(next) == 'T') {
				t1++;
			}
			
			if(a1>=a && c1>=c && g1>=g && t1>=t) {
				count++;
			}
			
		}
		
		System.out.println(count);
	}

}
