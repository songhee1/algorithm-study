import java.util.*;
import java.io.*;
class Solution{
	static long dp[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1; 
		dp[4] = dp[5] = 2;
		dp[6] = 3;
		for(int test_case = 1;test_case<=tc;test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i=7;i<=n;i++) {
				if(dp[i] == 0) {
					dp[i] = dp[i-5] + dp[i-1];
				}
			}
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
