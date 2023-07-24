package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_이진탐색1920 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		int arr[]=new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//이진탐색 기본조건 -> 오름차순 정렬
		Arrays.sort(arr);
		
		int a = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(a-- >0) {
			int find = Integer.parseInt(st.nextToken());
			
			int start = 0, end = n-1;
			int m = 0;
			boolean flag = false;
			while(start<=end) {
				m = (start+end)/2;
				if(arr[m] == find) {
					System.out.println(1);
					flag = true;
					break;
				}
				else if(arr[m]<find) {
					start = m+1;
				}else if(arr[m]>find) {
					end = m-1;
				}
			}
			
			if(flag == false) {
				System.out.println(0);
			}
		}
			
	}

}
