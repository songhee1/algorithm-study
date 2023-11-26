import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], n;
	static long dp[];
	static long maxSum, maxDpSum;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][2];
		dp = new long[n+2];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, 0);
		//dp();
		
		for(int i=1;i<n+1;i++) {
			maxDpSum = Math.max(maxDpSum, dp[i]);
		}
		
		System.out.println(maxSum);
		System.out.println(maxDpSum);
		
	}
	public static void dfs(int idx, int sum) {
		maxSum = Math.max(maxSum, sum);
		if(idx > n) {
			return;
		}
		
		if(idx+(arr[idx][0]-1) <= n) {
			dfs(idx+arr[idx][0], sum+arr[idx][1]);
		}
		dfs(idx+1, sum);
		
	}
	public static void dp() {
		for(int i=n;i>=1;i--) {
			int nextDay = i+arr[i][0];
			if(nextDay-1>n) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(dp[i+1], dp[nextDay]+arr[i][1]);
			}
		}
	}
}
