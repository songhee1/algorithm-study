import java.util.*;
import java.io.*;
class Solution{
	static int arr[];
	static long dp[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new long[n][2];
		dp[0][0] = 1; dp[0][1] = arr[0];
		dp[1][0] = 2; dp[1][1] = arr[0]+arr[1];
		
		long maxSum = 0;
		for(int i=2;i<n;i++) {
			dp[i][0] = 1;
			dp[i][1] = arr[i];
			if(dp[i-1][0]+1 <3) {
				if(dp[i][1]<arr[i]+dp[i-1][1]) {
					dp[i][0] = dp[i-1][0]+1;
					dp[i][1] = dp[i-1][1] + arr[i];
				}
			}
			
			if(dp[i][1]<arr[i]+dp[i-2][1]) {
				dp[i][0] = 1;
				dp[i][1] = dp[i-2][1] + arr[i];
			}
			
			maxSum = Math.max(maxSum, dp[i][1]);
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(dp[i][1]);
		}
		
		
		System.out.println(maxSum);
		
	}
}
