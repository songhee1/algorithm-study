import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], n;
	static boolean v[];
	static long maxSum;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][2];
		v = new boolean[n+1];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		find(1, 0);
		
		System.out.println(maxSum);
		
	}
	public static void find(int idx, int sum) {
		maxSum = Math.max(maxSum, sum);
		if(idx > n) {
			return;
		}
		
		for(int i=idx;i<n+1;i++) {
			int from = i;
			if(i+(arr[i][0]-1) > n) continue;
			int to = from + (arr[i][0]-1);
			if(AllFalse(from, to)) {
				MakeBoolean(from, to, true);
			   find(to+1, sum + arr[i][1]);
			   MakeBoolean(from, to, false);
			}
		}
	}
	
	public static boolean AllFalse(int from, int to) {
		for(int i=from;i<=to;i++) {
			if(v[i] == true) {
				return false;
			}
		}
		return true;
	}
	
	public static void MakeBoolean(int from, int to, boolean flag) {
		for(int i=from;i<=to;i++) {
			v[i] = flag;
		}
	}
}
