package DynamicProgramming;
import java.io.*;
import java.util.*;
public class BOJ_가장_큰_증가하는_부분수열의_합 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[], dp[], max[];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		max = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		max[1] = arr[1];
		boolean flag = false;
		for(int i=2;i<n+1;i++) {
			flag = false;
			for(int j=i-1;j>=1;j--) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
					max[i] = Math.max(max[i-1], dp[i]);
					flag = true;
					
				}
			}
			if(flag == false) {
				dp[i] = arr[i];
				max[i] = max[i-1];
			}
				
		}
		
		System.out.println(max[n]);
		

	}

}
