import java.util.*;
import java.io.*;
class Main{
	static int n, dp[][];
	static class Pair{
		int left;
		int right;
		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		dp = new int[41][2];
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			n = Integer.parseInt(br.readLine());
			
			for(int i=2;i<=n;i++) {
				dp[i][0] = -1;
				dp[i][1] = -1;
			}
			
			dp[0][0] = 1;
			dp[0][1] = 0;
			
			dp[1][0] = 0;
			dp[1][1] = 1;
			fibonacci(n);
			
			sb.append(dp[n][0]+" "+dp[n][1]).append("\n");
		}
		
		System.out.println(sb);
	}
	public static Pair fibonacci(int n) {
		if(n==0) {
			return new Pair(1,0);
		}else if(n==1) {
			return new Pair(0,1);
		}else {
			if(dp[n][0] == -1) {
				Pair p = fibonacci(n-1);
				Pair p1 = fibonacci(n-2);
				
				dp[n][0] = p.left+p1.left;
				dp[n][1] = p.right+p1.right;
				
			}
			
			return new Pair(dp[n][0], dp[n][1]);
		}
	}
	
}
