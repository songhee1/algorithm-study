import java.util.*;
import java.io.*;
class Solution{
	static int N, M, maxWeight;
	static int arr[];
	static boolean v[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			v = new boolean[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0, 0, 0);
			
			if(maxWeight == 0)
				maxWeight = -1;
			sb.append("#"+test_case+" ").append(maxWeight).append("\n");
			maxWeight = 0;
		}
		System.out.println(sb);
	}
	public static void find(int idx, int cnt, int weight) {
		if(cnt == 2) {
			if(weight>M) return;
			if(weight>maxWeight) {
				maxWeight = weight;
			}
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!v[i]) {
				v[i] = true;
				find(i+1, cnt+1, weight+arr[i]);
				v[i] = false;
			}
		}
	}
}
