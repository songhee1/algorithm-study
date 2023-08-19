package DynamicProgramming;
import java.io.*;
import java.util.*;
public class BOJ_최소편집길이_15483 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String a, b;
	public static int memo[][];
	public static void main(String[] args) throws Exception {
		a = br.readLine();
		b = br.readLine();
		
		memo = new int[a.length()+1][b.length()+1];
		System.out.println(find(0,0));
		
	}
	
	public static int find(int k, int h) {
		if(k == a.length() && h == b.length()) {
			return 0;
		}
		
		if(k == a.length()) {
			return k-h;
		}else if(h == b.length()) {
			return h-k;
		}
		
		int ans = Integer.MAX_VALUE;
		if(h+1 <= b.length()) {
		if(memo[k][h+1] == 0) memo[k][h+1] = find(k, h+1);
		ans = Math.min(ans, memo[k][h+1]);
		}
		
		if(k+1 <= a.length()) {
		if(memo[k+1][h] == 0) memo[k+1][h] = find(k+1, h);
		ans = Math.min(ans, memo[k+1][h]);
		}
		
		if(k+1 <= a.length() && h+1 <= b.length()) {
		if(memo[k+1][h+1] == 0) memo[k+1][h+1] = find(k+1, h+1);
		ans = Math.min(find(k+1, h+1), ans);
		}
		return ans;
	}

}
