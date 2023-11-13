import java.util.*;
import java.io.*;
class Solution{
	static int N, M;
	static int arr[];
	static String ZERO = "0001101";
	static String ONE = "0011001";
	static String TWO = "0010011";
	static String THREE = "0111101";
	static String FOUR = "0100011";
	static String FIVE = "0110001";
	static String SIX = "0101111";
	static String SEVEN = "0111011";
	static String EIGHT = "0110111";
	static String NINE = "0001011";
	static int CODE = 8;
	static boolean ifIn = false;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=test_case;tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[CODE];
			int idx = 0;
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<=M-56;j++) {
					String sub = s.substring(j, j+56);
					if(ifIn == true) continue;
					if(find(sub)) {
						break;
					}
				}
			}

			
			int holsu = 0;
			int zzak = 0;
			for(int i=0;i<CODE;i++) {
				if(i%2 == 0) {
					holsu += arr[i];
				}else zzak += arr[i];
			}
			if((holsu*3 + zzak)%10 == 0) {
				sb.append("#"+tc+" ").append(holsu+zzak).append("\n");
			}else sb.append("#"+tc+" ").append(0).append("\n");
			
			ifIn = false;
		}
		
		System.out.print(sb);
	}
	public static boolean find(String s) {
		int idx = 0;
		
		for(int j=0;j<=55;j++) {
			String sub = s.substring(j, j+7);
			
			if(!sub.equals(ZERO) && !sub.equals(ONE) && !sub.equals(TWO) && !sub.equals(THREE) && !sub.equals(FOUR)
					&& !sub.equals(FIVE) && !sub.equals(SIX) && !sub.equals(SEVEN) && !sub.equals(EIGHT) && !sub.equals(NINE)) {
				ifIn = false;
				return false;
			}
			
			if(sub.equals(ZERO)){
				arr[idx++] = 0;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(ONE)){
				arr[idx++] = 1;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(TWO)){
				arr[idx++] = 2;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(THREE)){
				arr[idx++] = 3;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(FOUR)){
				arr[idx++] = 4;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(FIVE)){
				arr[idx++] = 5;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(SIX)){
				arr[idx++] = 6;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(SEVEN)){
				arr[idx++] = 7;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(EIGHT)){
				arr[idx++] = 8;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}else if(sub.equals(NINE)){
				arr[idx++] = 9;
				System.out.println(j);
				j = j+6;
				ifIn = true;
			}
		
		}
		
		return true;
	}
}
