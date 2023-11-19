import java.util.*;
import java.io.*;
class Solution{
	static int start, end;
	static String s, sub;
	static String arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=10;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			s = st.nextToken();
			
			for(int i=0;i<s.length()-1;i++) {
				if(Character.getNumericValue(s.charAt(i)) == 
						Character.getNumericValue(s.charAt(i+1))) {
					start = i; end = i+1;
					find();
					i=-1;
				}
			}
			
			sb.append("#"+test_case+" ").append(s).append("\n");
		}
		System.out.println(sb);
	}
	public static void find() {
		while(Character.getNumericValue(s.charAt(start)) == 
				Character.getNumericValue(s.charAt(end))) {
			start-=1; end+=1;
			if(start<0 || end>=s.length()) break;
			
		}
		
		if(start<0 && end>=s.length()) {
			start = 0; end = s.length()-1;
		}else if(start<0) {
			start = 0;
			end--;
		}
		else if(end>=s.length()) {
			end = s.length()-1;
			start++;
		}
		else {
			start++; end--;
		}
		
		String s1 = s.substring(0, start);
		String s2 = s.substring(end+1, s.length());
		s = s1+s2;
	}
	
}
