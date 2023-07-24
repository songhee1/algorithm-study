package dfs;
import java.io.*;
import java.util.*;
public class SWEA_최소합5188 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[][], minSum, n;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1;i<tc+1; i++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int [n][n];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			minSum = Integer.MAX_VALUE;
			dfs(0,0,arr[0][0]);
			
			sb.append("#"+i).append(" ").append(minSum).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void dfs(int i, int j, int sum) {
		if(i == n-1 && j == n-1) {
			minSum = Math.min(minSum, sum);
			return;
		}
		
		if(i+1<n) {
			dfs(i+1, j, sum+arr[i+1][j]);
		}
		if(j+1<n) {
			dfs(i, j+1, sum+arr[i][j+1]);
		}
	}
}
