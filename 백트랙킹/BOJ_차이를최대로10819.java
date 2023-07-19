package com.day07.backtracking;
import java.io.*;
import java.util.*;
public class BOJ_차이를최대로10819 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[], arrCopy[],  maxNum = Integer.MIN_VALUE, n;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			arrCopy = arr.clone();
			for(int j=0;j<n;j++) {
				if(i!=j) {
					int temp = arr[i];
					arrCopy[i] = arr[j];
					arrCopy[j] = temp;
					
					find();
				}
			}
		}
		
		System.out.println(maxNum);
	}
	
	public static void find() {
		int sum = 0;
		for(int i=0;i<n-2;i++) {
			sum += Math.abs(arrCopy[i]-arrCopy[i+1]);
		}
		
		if(maxNum < sum) {
			maxNum = sum;
		}
	}

}
