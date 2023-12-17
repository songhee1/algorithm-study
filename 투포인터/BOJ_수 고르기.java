import java.util.*;
import java.io.*;
class Solution{
	static int arr[], min = Integer.MAX_VALUE, N, M;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int st1 = 0; 
		int en = 0;
		
		while(st1<arr.length && en<arr.length) {
			if(arr[en]-arr[st1]<M) {
				en++;
			}else {
				min = Math.min(min, arr[en]-arr[st1]);
				st1++;
			}
		}
		
		
		System.out.println(min);
		
	}
}
