package com.edu.test;
import java.io.*;
import java.util.*;
public class BOJ_2075 {
	public static int arr[];
	public static void main(String[] args)throws Exception {
		arr = new int [2000000001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int maxNum = 0;
		List<Integer> list = new ArrayList();
		int count = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				
				int a = Integer.parseInt(st.nextToken());
				
				if(count==n) {
					int minIndex = 0;
					for(int k=1;k<n;k++) {
						if(list.get(minIndex)>list.get(k)) {
							minIndex = k;
						}
					}
					
					if(list.get(minIndex) < a) {
						list.remove(minIndex);
						list.add(a);
					}
				}else {
					list.add(a);
					count++;
				}
//				
			}
		}
		
	    Collections.sort(list);
		
		System.out.println(list.get(list.size()-n));
	}

}
