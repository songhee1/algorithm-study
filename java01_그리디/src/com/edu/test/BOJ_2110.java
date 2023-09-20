package com.edu.test;
import java.io.*;
import java.util.*;
public class BOJ_2110 {
	public static int arr[], maxDist = 0, n, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int min_distance = 1;
		int max_distance = arr[n]-arr[1];
		
		while(min_distance<=max_distance) {
			int mid_distance = (min_distance+max_distance)/2;
			int standard = arr[1]; //비교거리 기준이 되는 집
			int count = 1; //공유기 설치 대수. 처음에는 첫번째 arr[1]위치인 집에 공유기를 설치한다고 가정하고 시작.
			for(int i=1;i<n+1;i++){
				if(arr[i]-standard>=mid_distance) {
					count++;
					standard = arr[i];
				}
			}
			
			if(count < c) {
				max_distance = mid_distance -1;
			}else if(count >= c) {
				maxDist = Math.max(maxDist, mid_distance);
				System.out.println(mid_distance);
				min_distance = mid_distance +1;
			}
		}
		
		System.out.println(maxDist);
	}

}
