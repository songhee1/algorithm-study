package com.other.fullfind;
import java.io.*;
import java.util.*;
public class BOJ_1107 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n, m, arr[];
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int a, mok, namo;
		boolean flag = false;
		int maxNum = 0;
		for(int i=500000;i>=0;i--) {
			mok = i; namo = 1;
			flag = false;
			while(mok!=0) {
				mok = mok/10;
				namo = mok%10;
				
				for(int j = 0;j<m;j++) {
					if(namo == arr[j]) {
						flag = true;
					}
				}
				if(flag == true) {
					break;
				}
			}
			
			if(flag == false) {
			    if(maxNum<i) {
			    	maxNum = i;
			    }
			}
		}
		
		a = Math.abs(n-maxNum);
		
		int mok1 = maxNum, namo1;
		int count = 0;
		
		while(mok1!=0) {
			mok1 = mok1/10;
			namo1 = mok1%10;
			
			count++;
		}
		
		System.out.println(count+a);
		
	}

}
