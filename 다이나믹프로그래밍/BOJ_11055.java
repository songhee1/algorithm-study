import java.util.*;
import java.io.*;
class Solution{
	static long dp[], maxSum;
	static int arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new long[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i;j>=0;j--) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], arr[i]+dp[j]);
				}
			}
		}
		
		long maxSum = 0;
		for(int i=0;i<n;i++) {
			if(maxSum < dp[i]) {
				maxSum = dp[i];
			}
		}
		
		System.out.println(maxSum);
		
	}
}
