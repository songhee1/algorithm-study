package com.other.fullfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int l, c;
	public static String arr[], anw[], answer;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new String[c];
		anw = new String[l];
		visit = new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<c;i++) {
			
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		make_secret(0,0,-1);
		
		System.out.println(sb);
	}
	
	public static void make_secret(int count, int idx, int id) {
		if(count == l) {
			int moum = 0, zaum = 0;
			for(int i=0;i<anw.length;i++) {
				if(anw[i].equals("a") || anw[i].equals("e") || anw[i].equals("i") || anw[i].equals("o") || anw[i].equals("u")) {
					moum++;
				}else {
					zaum ++;
				}
			}
			
			if(moum >= 1 && zaum >=2) {
				for(int i=0;i<anw.length;i++) {
					sb.append(anw[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i=id+1;i<c;i++) {
			if(!visit[i]) {
				visit[i] = true;
				anw[idx] = arr[i];
				make_secret(count+1, idx+1, i);
				visit[i] = false;
			}
		}
	}

}
