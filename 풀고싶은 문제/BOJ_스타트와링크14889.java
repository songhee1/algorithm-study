package dfs;
import java.io.*;
import java.util.*;
public class BOJ_스타트와링크14889 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[][], n;
	public static long minSum = Integer.MAX_VALUE;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(minSum);
	}
	
	public static void dfs(int count, int idx) {
		if(count == n/2) {
			int sumST = 0;
			int sumLI = 0;
			for(int i = 0; i<n ;i++) {
				for(int j = i+1; j<n ;j++) {
					if(visit[i]== true && visit[j] == true ) {
						sumST += arr[i][j]+arr[j][i];
					}else if(visit[i] == false && visit[j] == false) {
						sumLI += arr[i][j]+arr[j][i];
					}
				}
			}
			
			minSum = Math.min(minSum, Math.abs(sumST - sumLI));
			return;
		}
		
		for(int i=idx;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(count+1, i+1);
				visit[i] = false;
			}
		}
	}

}
