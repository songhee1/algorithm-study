package com.edu.boj;
/*
 * n���� �־����� �� i��° ������ j��° ������ ���� ���ϴ� ���α׷��� �ۼ��϶�
 * 
 * �Է�
 * 1-���� ���� n + ���� ���ؾ��ϴ� Ƚ�� m 
 * 2-n���� �� (<=1000�� �ڿ���)
 * 3~ ���� ���ؾ��ϴ� ���� i j
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
