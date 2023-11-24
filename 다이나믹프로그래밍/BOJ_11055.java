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
		dp = new long[1001];
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		maxSum = dp[0];
		for(int i=1;i<n;i++) {
			if(arr[i-1]<arr[i]) {
				dp[i] = dp[i-1]+arr[i];
			}else if(arr[i-1]>arr[i]){
				dp[i] = find(i-1, i) + arr[i];
			}else 
				dp[i] = arr[i];
			
			maxSum = Math.max(maxSum, dp[i]);
		}
		
		System.out.println(maxSum);
		
	}
	public static long find(int idx, int target) {
		for(int i=idx;i>=0;i--) {
			if(arr[target]>arr[i]) {
				return dp[i];
			}
		}
		
		return 0;
		
	}
	
}
