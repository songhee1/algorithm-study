import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], copy[][];
	static int N;
	static boolean v[];
	static int maxEggs;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][2];
		copy = new int[N+1][2];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(1, new ArrayList<>());
		
		System.out.println(maxEggs);
		
	}
	public static void find(int cnt, List<Integer> indexList) {
		if(cnt == N+1 ) {
			for(int i=1;i<N+1;i++) {
				copy[i] = arr[i].clone();
			}
			
			breakEggs(indexList);
			
			int sum = 0;
			for(int i=1;i<N+1;i++) {
				if(copy[i][0]<=0) {
					sum++;
				}
			}
			
			maxEggs = Math.max(maxEggs, sum);
			
			return;
		}
		
		for(int i=1;i<arr.length;i++) {
			if(i != cnt) {
				indexList.add(i);
				find(cnt+1, indexList);
				indexList.remove(indexList.size()-1);
			}
		}
	}
	private static void breakEggs(List<Integer> indexList) {
		for(int i=1;i<N+1;i++) {
			int idx = indexList.get(i-1);
			
			if(copy[i][0] > 0 && copy[idx][0] >0) {
				copy[i][0] -= copy[idx][1];
				copy[idx][0] -= copy[i][1];
			}
		}
		
	}
	

	
}
