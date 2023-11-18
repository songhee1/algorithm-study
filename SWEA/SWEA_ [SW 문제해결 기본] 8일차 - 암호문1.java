import java.util.*;
import java.io.*;
class Solution{
	static int x, y, z;
	static int N, order; //원본 암호문의 길이, 명령어의 갯수
	static List<Integer> list;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=10;test_case++) {
			//원본 암호문 길이
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			//원본 암호문
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			//명령어의 갯수
			order = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			while(order-->0) {
				//I
				String insert = st.nextToken();
				
				//X
				x = Integer.parseInt(st.nextToken());
				
				//Y
				y = Integer.parseInt(st.nextToken());
				
				//S
				List<Integer> sub = new ArrayList<>();
				while(y-->0) {
					sub.add(Integer.parseInt(st.nextToken()));
				}
				list.addAll(x, sub);
			}
			
			sb.append("#"+test_case+" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
