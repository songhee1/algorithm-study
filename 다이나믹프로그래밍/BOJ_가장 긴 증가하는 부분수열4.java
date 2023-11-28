import java.util.*;
import java.io.*;
class Solution{
	static int arr[];
	static long dp[], LIS;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int [n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new long[n];
		dp[0] = 1;
		LIS = 1;
		for(int i=1;i<n;i++) {// arr[i] - 뒤의 값
			dp[i] = 1;
			for(int j=0;j<i;j++) { //arr[j] - 앞의 값
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					LIS = Math.max(LIS, dp[i]);
				}
			}
		}
		
		Stack<Integer> s = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			if(LIS == dp[i]) {
				s.add(arr[i]);
				LIS--;
				if(LIS == 0) break;
			}
		}
		
		int size = s.size();
		sb.append(size).append("\n");
		for(int i = 0;i<size;i++) {
			sb.append(s.pop()).append(" ");
		}
		
		
		System.out.println(sb);
		
	}
}
