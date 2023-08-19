package Greedy;
import java.io.*;
import java.util.*;
public class BOJ_제자리_멀리뛰기 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[], cha[][], copy[][];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int [n+1];
		cha = new int [n+1][2];
		copy = new int[n+1][2];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[n] = d;
		Arrays.sort(arr);
		cha[0][0] = 0;
		cha[0][1] = arr[0];
		for(int i=1;i<n;i++) {
				cha[i][0] = i;
				cha[i][1] = arr[i]-arr[i-1];
			
		}
		
		arr[n] = d;
		cha[n][0] = n;
		cha[n][1] = arr[n] - arr[n-1];
		
		copy = cha.clone();
		Arrays.sort(copy, (o1, o2)-> o1[1]-o2[1]);
		
		int i = 0;
		while(i<cha.length) {
			if(i == m) break;
			for(int j = copy[i][0]+1; j<=n;j++) {
				if(cha[j][1]!= 0) {
					cha[j][1] = cha[j][1] + cha[copy[i][0]][1];
					cha[copy[i][0]][1] = 0;
					break;
				}
			}
			i++;
		}
		
		int minNum = Integer.MAX_VALUE;
		for(int j = 0;j<=n;j++) {
			if(cha[j][1] != 0) {
				minNum = Math.min(minNum, cha[j][1]);
			}
		}
		System.out.println(minNum);
	}

}
