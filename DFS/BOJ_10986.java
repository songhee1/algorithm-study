package simul;

import java.io.*;
import java.util.*;

public class BOJ_10986 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int n,m, arr[], count;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=1;i<n+1;i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		
		for(int i=1;i<=n;i++) {
//			if(arr[j])
		}
		
		System.out.println(count);
	}

}
