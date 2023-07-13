package com.other.fullfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9742 {

		public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		public static StringTokenizer st;
		public static StringBuilder sb = new StringBuilder();
		public static int k, idx, findNum;
		public static String s, answer;
		public static char arr[], anw[];
		public static boolean isvisited[], flag;
		public static void main(String[] args) throws Exception {
			String input = "";
			while((input = br.readLine()) != null) {
				st = new StringTokenizer(input);
				
				s = st.nextToken();
				k =Integer.parseInt(st.nextToken());
				arr = new char[s.length()];
				
				for(int i=0;i<arr.length;i++) {
					arr[i] = s.charAt(i);
				}
				
				isvisited = new boolean[arr.length];
				anw = new char [arr.length];
				findNum = 0;
				
				make_sort(0,0);
				
				if(findNum < k) {
					answer = "No permutation";
				}
				
				sb.append(s+" "+k+" = ").append(answer).append("\n");
			}
			
			System.out.println(sb);
			
		
	}
		public static void make_sort(int count, int idx) {
			if(count == arr.length) {
				findNum++;
				if(findNum == k) {
					answer = new String(anw);
				}
				return;
			}
			
			for(int j=0;j<arr.length;j++) {
				if(isvisited[j] == false) {
					isvisited[j] = true;
					anw[idx] = arr[j];
					make_sort(count+1, idx+1);
					isvisited[j] = false;
				}
			}
			
		}

}
