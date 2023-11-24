import java.util.*;
import java.io.*;
class Solution{
	static int n, k, arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		// 10  9  5  1 
		//   1  
		// 4  1
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n-1;i++) {
			pq.add(arr[i+1]-arr[i]);
		}
		
		
		for(int i=1;i<k;i++) {
			pq.poll();
		}
		
		int sum = 0;
		int size = pq.size();
		for(int i=0;i<size;i++) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
	
}
