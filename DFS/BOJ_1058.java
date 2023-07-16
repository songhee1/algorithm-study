package simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1058 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				if(s.charAt(j) == 'Y') {
					arr[i][j] = 1;
					arr[j][i] = 1;
				}
			}
		}
		
		int maxNum = 0;
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j]++;
						arr[j][i]++;
						
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maxNum = Math.max(arr[i][j], maxNum);
			}
		}
		
		
		System.out.print(maxNum);
	}

}
