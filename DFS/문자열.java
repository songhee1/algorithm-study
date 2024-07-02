package no;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	static int T;
	static String S, E;
	static boolean isPossible = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
        	isPossible = false;
        	S = br.readLine();
        	E = br.readLine();
        	dfs(new StringBuilder(E));
        	sb.append("#").append(i+1).append(" ");
        	if(isPossible) {
        		sb.append("Yes\n");
        	}else {
        		sb.append("No\n");
        	}
        }
        System.out.println(sb);
    }
	private static void dfs(StringBuilder input) {
		int len = input.length();
		if(len == S.length()) {
			if(input.toString().equals(S)) {
				isPossible = true;
			}
			return;
		}
		
		char ch = input.charAt(len-1);
		input.delete(len-1, len);
		System.out.println(ch+", 현재 input 값 : "+input);

		if(ch == 'X') {
			dfs(input);
			System.out.println(input.toString());
			System.out.println("============");
		}else {
			dfs(input.reverse());
			System.out.println(input.toString());
			System.out.println("============");
		}
	}
	
	
}
