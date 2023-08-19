package Greedy;
import java.io.*;
import java.util.*;
public class BOJ_뒤집기 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		int num = 0;
		int init = 0;
		
		for(int i=1;i<s.length();i++) {
			if(s.charAt(init) != s.charAt(i)) {
				num ++;
				
				String make = "";
				int out = 0;
				char stand = s.charAt(init);
				for(int j=i;j<s.length();j++) {
					if(stand == '0') {
						if(s.charAt(j)== '1') {
							make += '0';
						}else {
							out = j;
							break;
						}
					}else {
						if(s.charAt(j) == '0') {
							make+= '1';
						}else {
							out = j;
							break;
						}
					}
				}
				
				if(out != 0) {
					s = s.substring(0, i) + make + s.substring(out, s.length());
					init = out;
					i = out;
				}else {
					break;
				}
			}
		}
		
		System.out.println(num);
	}

}
