package com.day06.greedy;
import java.io.*;
import java.util.*;
public class BOJ_전자카트 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[][], num, minNum, pre, lastPre, tc;
	public static boolean visit[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=tc;i++) {
			num = Integer.parseInt(br.readLine());
			
			arr = new int[num][num];
			visit = new boolean[num];
			minNum = Integer.MAX_VALUE;
			lastPre = 0;
			
			for(int j=0;j<num;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<num;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("minNum : "+ minNum);
			dp(0, 0, 0);
			
			sb.append("#"+i).append(" ").append(minNum+arr[lastPre][0]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dp(int count, int sum, int pre) {
		
		if(count == num-1) {
			if(minNum> sum) {
				minNum = sum;
				lastPre = pre;
				System.out.println("minNum: "+minNum+", lastPre: "+lastPre);
			}
			return;
		}
		
		for(int i=1;i<num;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dp(count+1, sum+arr[pre][i], i);
				visit[i] = false;
			}
		}
	}

}
