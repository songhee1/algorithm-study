import java.util.*;
import java.io.*;
class Solution{
	static int P, Q, R, S, W;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			int Asum = P *W;
			int Bsum = Q;
			if(W>R) Bsum+= (W-R)*S;
			
			if(Asum>Bsum) sb.append("#"+test_case+" ").append(Bsum).append("\n");
			else sb.append("#"+test_case+" ").append(Asum).append("\n");
			
		}
		
		System.out.println(sb);
	}
}
