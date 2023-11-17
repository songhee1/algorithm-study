import java.util.*;
import java.io.*;
class Solution{

	static int N, W, maxScore;
	static int bag[][], dp[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=1;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			bag = new int[N][2];
			dp = new int[N+1][W+1];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bag[i][0] = Integer.parseInt(st.nextToken());
				bag[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(bag, (o1, o2)->o1[0]-o2[0]);
			
			for(int i=1;i<N+1;i++) {
				int w = bag[i-1][0];
				int v = bag[i-1][1];
				for(int j=1;j<W+1;j++) {
					if(j>=w) {
						dp[i][j] = Math.max(dp[i-1][j], v+dp[i-1][j-w]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<W+1;j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
			
			sb.append("#"+test_case+" ").append(dp[N][W]).append("\n");
			maxScore = 0;
		}
		
		System.out.println(sb);
	}
	
}
