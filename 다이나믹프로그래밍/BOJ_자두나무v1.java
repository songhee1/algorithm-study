import java.util.*;
import java.io.*;
class Solution{
	static long maxNum;
	static int arr[], T, W;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = new int[T+1];
		for(int i=1;i<T+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(1, 0, 1, 0);
		System.out.println(maxNum);
	}
	public static void dfs(int cnt, long sum, int choice, int num) {
		if(cnt > T) {
			maxNum = Math.max(maxNum, sum);
			return;
		}
		
		if(arr[cnt] == 1) {
			if(choice == 1) {
				dfs(cnt+1, sum+1, 1, num);
				dfs(cnt+1, sum+1, 2, num+1);
			}else {
				dfs(cnt+1, sum, 2, num);
				dfs(cnt+1, sum, 1, num+1);
			}
			
		}else {
			if(choice == 1) {
				dfs(cnt+1, sum, 1, num);
				dfs(cnt+1, sum, 2, num+1);
			}else {
				dfs(cnt+1, sum+1, 2, num);
				dfs(cnt+1, sum+1, 1, num+1);
			}
		}
	}
}
