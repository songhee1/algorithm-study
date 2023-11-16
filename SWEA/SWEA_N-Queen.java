import java.util.*;
import java.io.*;
class Solution{
	static int n, arr[][], sum;
	static boolean hang[], yal[], left[], right[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			n = Integer.parseInt(br.readLine());
			sum = 0;
			
			hang = new boolean[n];
			yal = new boolean[n];
			left = new boolean[(n-1)*2+1];
			right = new boolean[(n-1)*2+1];
			
			find(0);
			
			sb.append("#"+test_case+" "+sum).append("\n");
		}
		
		System.out.println(sb);
	}
	public static void find(int count) {
		if(count == n) {
			sum++;
			return;
		}
		for(int i = 0; i<n; i++) {
			if(yal[i] == false && left[(n-1)-(i-count)] == false
			&& right[count+i] == false) {
				yal[i] = true;
				left[(n-1)-(i-count)] = true;
				right[count+i] = true;
				find(count+1);
				yal[i] = false;
				left[(n-1)-(i-count)] = false;
				right[count+i] = false;
			}
		}
		
	}
	
}
