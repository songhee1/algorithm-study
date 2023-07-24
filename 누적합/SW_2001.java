package com.day01.array;
/*
 * nxn 배열 안 숫자는 영역에 존재하는 파리의개수를 의미한다.
 * mxm 크기의 파리채를 한번 내리쳐서 최대한 많은 파리를 죽이고자 한다.
 * 죽은 파리의 개수를 구하라.(최대한 많이 죽였을 때의 파리의 수를 구하라)
 * 
 * 입력
 * 1- 테스트케이스 개수 t
 * 2- 각 테스트 케이스(n, m)
 * 3~ nxn 배열이 주어진다/
 */
import java.io.*;
import java.util.*;
public class SW_2001 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int arr[][], n, m, dp[][];
	public static void main(String[] args) throws Exception{
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=testcase;i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1][n+1];
			dp = new int[n+1][n+1];
			
			
			for(int j=1;j<=n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=1;k<=n;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int maxNum = 0;
			for(int j=1;j<n-m+1;j++) {
				for(int k=1;k<n-m+1;k++) {
					
					int total = 0;
					for(int h=0;h<m;h++) {
						for(int a=0;a<m;a++) {
							total += arr[j+h][k+a];
						}
					}
					maxNum = Math.max(maxNum, total);
				}
			}
			
			
			sb.append("#"+i+" "+maxNum).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
