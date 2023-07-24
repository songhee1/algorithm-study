package simul;
import java.io.*;
import java.util.*;
public class SW_17319 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static String s, answer;
	public static void main(String[] args)throws Exception {
		int ts = Integer.parseInt(br.readLine());
		
		for(int i=1;i<ts+1;i++) {
			int num = Integer.parseInt(br.readLine());
			
			s = br.readLine();
			boolean flag = true;
			
			for(int j = 0;j<num/2;j++) {
				if(s.charAt(j) != s.charAt(j+num/2)) {
					flag = false;
				}
				
			}
			
			if(num == 1) flag = false;
			else if(num%2 ==1) flag = false;
			
			if(flag == false) {
				answer = "No";
			}else {
				answer = "Yes";
			}
			
			sb.append("#"+i).append(" ").append(answer).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
