package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_3187 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, arr[][];
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][2];
		for(int i=0;i<n;i++) {
		st = new StringTokenizer(br.readLine());
		arr[i][0] = Integer.parseInt(st.nextToken());
		arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				if(o1[1]<o2[1]) {
					return -1;
				}else if(o1[1] == o2[1]) {
					if(o1[0]<o2[0]) {
						return -1;
					}else if(o1[0] == o2[0])
						return 0;
					else return 1;
				}else
					return 1;
			}
		});
		/*
		 * [1] 종료시간기준 오름차순, 같으면 시작시간 오름차순으로 정렬 
		 * Arrays.sort(arr, (x, y)->x[1]==y[1]?(x[0]-y[0]):x[1]-y[1]);
		 * 
		 * 
		 */
		
		int count = 1;
		int start = 0;
		for(int i=1;i<n;i++) {
			if(arr[i][0] >= arr[start][1]) {
				start = i;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
