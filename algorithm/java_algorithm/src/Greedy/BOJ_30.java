package Greedy;
import java.io.*;
import java.util.*;
public class BOJ_30 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int []add;
	public static void main(String[] args)throws Exception {
		List<Integer> list = new ArrayList<>();
		String s = br.readLine();
		add = new int [s.length()];
		
		int total = 0 ;
		for(int i=0;i<s.length();i++) {
			list.add(s.charAt(i)-'0');
			add[i] = total + (s.charAt(i)-'0');
			total = add[i];
		}
		
		Collections.sort(list, (o1, o2)-> o2-o1);
		
		if(list.get(s.length()-1)!=0) {
			System.out.println(-1);
			return;
		}
		if(s.length() == 1) {
			System.out.println(-1);
			return;
		}
		
		int i = s.length()-2;
		
		while(list.size()>2) {
			if(total %3 == 0) {
				String ss = "";
				int len = list.size();
				for(int h = 0;h<len;h++) {
					ss+= String.valueOf(list.remove(0));
				}
				System.out.println(ss);
				return;
			}
			System.out.println(-1);
			return;
//			list.remove(i);
//			total -= add[i];
//			i --;
		}
		
		if(list.get(0) != 3) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(30);
		return;
		
		
	}

}
