import java.util.*;
import java.io.*;
class Solution{
	static int dp[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int idx = 4;
		for(int test_case=1;test_case<=tc;test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			if(dp[n] == 0) {
				for(int i=idx;i<=n;i++) {
					dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
				}
				idx = Math.max(idx, n);
			}
			
			sb.append(dp[n]).append("\n");
		}
		
		
		System.out.println(sb);
	}
	
}
