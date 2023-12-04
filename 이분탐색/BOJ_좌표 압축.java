import java.util.*;
import java.io.*;
class Solution{
	static int arr[], original[];
	static Map<String, Integer> m = new HashMap<>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			String s = st.nextToken();
			arr[i] = Integer.parseInt(s);
		}
		original = arr.clone();
		
		Arrays.sort(arr);
		
		int before = arr[0];
		int befCnt = 0;
		
		Map<Integer, Integer> m = new HashMap<>();
		m.put(before, befCnt);
		for(int i=1;i<n;i++) {
			if(arr[i] == before) {
				continue;
			}else {
				before = arr[i];
				befCnt += 1;
				m.put(before, befCnt);
			}
		}
		
		for(int i=0;i<n;i++) {
			sb.append(m.get(original[i])+" ");
		}
		
		System.out.println(sb);
		
	}
}
