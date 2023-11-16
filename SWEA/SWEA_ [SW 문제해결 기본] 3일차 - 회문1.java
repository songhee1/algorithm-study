import java.util.*;
import java.io.*;
class Solution{
	static int len, count;
	static String arr[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=10;test_case++) {
			len = Integer.parseInt(br.readLine());
			count = 0;
			arr = new String[8][8];
			for(int i=0;i<8;i++) {
				String s = br.readLine();
				for(int j=0;j<8;j++) {
					arr[i][j] = s.substring(j, j+1);
				}
			}
			
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					xaxis(i, j);
					yaxis(i, j);
					
				}
			}
			
		
			sb.append("#"+test_case+" ").append(count).append("\n");
			
		}
		
		System.out.println(sb);
	}
	public static void xaxis(int i, int j) {
		String s1 = "";
		System.out.println(i+","+j +"|| x");
		if(i+len-1>=8) return;
		for(int k=i;k<i+len;k++) {
			s1 += arr[k][j];
		}
		
		String s2 = "";
		for(int k=i+len-1;k>=i;k--) {
			s2+=arr[k][j];
		}
		
		System.out.println(s1+","+s2);
		if(s1.equals(s2)) {
			count++;
			System.out.println("find");
		}
	}
	public static void yaxis(int i, int j) {
		String s1 = "";
		System.out.println(i+","+j +"|| y");
		if(j+len-1>=8) return;
		for(int k=j;k<j+len;k++) {
			s1 += arr[i][k];
		}
		
		String s2 = "";
		for(int k=j+len-1;k>=j;k--) {
			s2+=arr[i][k];
		}
		System.out.println(s1+","+s2);
		if(s1.equals(s2)) {
			count++;
			System.out.println("find");
		}
	}

}
