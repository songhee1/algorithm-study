package dynamic;
import java.io.*;
import java.util.*;
public class BOJ_RGB거리 {
	public static StringTokenizer st;
	public static int arr[][], dp[][];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		arr = new int [n+1][4];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][4];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		dp[1][3] = arr[1][3];
		
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<4;j++) {
				if(j == 1) {
					dp[i][j] = Math.min(dp[i-1][3]+arr[i][1], dp[i-1][2] + arr[i][1]);
				}else if(j == 2) {
					dp[i][j] = Math.min(dp[i-1][1]+arr[i][2], dp[i-1][3] + arr[i][2]);
				}else if(j == 3) {
					dp[i][j] = Math.min(dp[i-1][1]+arr[i][3], dp[i-1][2] + arr[i][3]);
				}
			}
		}
		
		int minNum = dp[n][1];
		if(minNum>dp[n][2]) minNum = dp[n][2];
		if(minNum>dp[n][3]) minNum = dp[n][3];
		
		System.out.println(minNum);
		
		
		
		
		
	}

}
