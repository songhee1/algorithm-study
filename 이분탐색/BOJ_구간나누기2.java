import java.util.*;
import java.io.*;
class Solution{
	static int arr[], N, M, left, right, mid;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// M작거나 같아야하니까 1 -> 2 -> 3 ...dfs 차이를 계속 더해주고 최솟값으로 갱신??
		// 값을 기준으로 left, right, mid 정하기
		
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		left = 0;
		
		while(left<right) {
			mid = (left+right)/2;
			System.out.println(left+", "+right);
			if(func(mid) <=M) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(right);
		
	}
	public static int func(int m) {
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		int range = 1; //구간의 수 (처음엔 인덱스 0부터 시작하므로 1개부터 시작)4
		
		/*
		 left = 4 right = 7 mid = 5
		 left mid right 갱신하는게 모든 값을 확인할수없으니까 이분탐색으로 최대한 
		 나누는 구간 갯수에 가깝게 찾는거니까  mid 증가하게 되면 left도 하고 mid감소하면 right감소하는거니까
		 1 5 4 6 2 1 3 7 
	 min 1 1
	 max 1 5
	 //  
		 * */
		
		for(int i=0;i<N;i++) {
			maxValue = Math.max(maxValue, arr[i]);
			minValue = Math.min(minValue, arr[i]);
			
			if(maxValue-minValue > m) {
				maxValue = Integer.MIN_VALUE;
				minValue = Integer.MAX_VALUE;
				
				i--;
				range++;
				
			}
			
		}
		
		return range;
	}
	
}
