import java.util.*;
import java.io.*;
class Solution{
	static int arr[], N, M, left = 1, right, mid, maxValue;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
			left = Math.min(left, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		while(left<=right) {
			mid = (left+right)/2;
			if(solve(mid)<=M) {
				maxValue = Math.max(maxValue, mid);
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(maxValue);
		
	}
	public static int solve(int m) {
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(m<=arr[i]) {
				sum += m;
			}else {
				sum +=arr[i];
			}
		}
		return sum;
	}
	
}
