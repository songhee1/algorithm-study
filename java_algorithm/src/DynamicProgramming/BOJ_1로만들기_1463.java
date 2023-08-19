package DynamicProgramming;
import java.io.*;
import java.util.*;
public class BOJ_1로만들기_1463 {
	public static int memo[];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		memo = new int[n+1];
		
		for(int i=2;i<n+1;i++) {
			if(i == 2 || i == 3) {
				memo[i] = 1;
				continue;
			}
			
			if(i%2 == 0) {
				if(memo[i] == 0) memo[i] = memo[i/2] + 1;
				else memo[i] = Math.min(memo[i], memo[i/2]+1);
			}
			if(i%3 == 0) {
				if(memo[i] == 0) memo[i] = memo[i/3] + 1;
				else memo[i] = Math.min(memo[i], memo[i/3]+1);
			}
			
			if(memo[i] == 0) memo[i] = memo[i-1]+1;
			else memo[i] = Math.min(memo[i], memo[i-1]+1);
		}
		
		
		System.out.println(memo[n]);
		
//		System.out.println(find(n));
	}
	public static int find(int n) {
		if(n == 2 || n == 3) {
		   return memo[n] = 1;
		}
		
		if(n % 2 == 0) {
			if(memo[n/2] == 0) memo[n/2] = find(n/2);
			if(memo[n] != 0) {
				memo[n] = Math.min(memo[n], memo[n/2]+1);
			}else {
				memo[n] = memo[n/2] + 1;
			}
		}
		if(n % 3 == 0) {
			if(memo[n/3] == 0) memo[n/3] = find(n/3);
			if(memo[n] != 0) {
				memo[n] = Math.min(memo[n], memo[n/3]+1);
			}else {
				memo[n] = memo[n/3] + 1;
			}
		}
		
		
		if(memo[n-1] == 0) memo[n-1] = find(n-1);
		if(memo[n] != 0)
			memo[n] = Math.min(memo[n], memo[n-1]+1);
		else {
			memo[n] =  memo[n-1] + 1;
		}
		
		return memo[n];
	}

}
