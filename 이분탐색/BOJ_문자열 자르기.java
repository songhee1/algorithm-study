import java.util.*;
import java.io.*;
class Solution{
	static String arr[][];
	static int R, C, count;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new String[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = s.substring(j, j+1);
			}
		}
		
		List<String> sList = new ArrayList<>();
		for(int i=0;i<C;i++) {
			String sub1 = "";
			for(int j=0;j<R;j++) {
				sub1 += arr[j][i];
			}
			sList.add(sub1);
		}
		
		for(int i=1;i<R;i++) {
			Set<String> set = new HashSet<>();
			boolean flag = false;
			for(int j=0;j<sList.size();j++) {
				String sub = sList.get(j).substring(i, R);
				if(set.contains(sub)) {
					flag = true; break;
				}else set.add(sub);
			}
			if(flag) break;
			count++;
		}
		
		System.out.println(count);
	}
	
}
