package Greedy;
import java.io.*;
import java.util.*;
public class BOJ_신입사원 {
	public static int arr[], count;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1];
			count = 0;
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a] = b; 
			}
			
			boolean flag = false;
			for(int i=n;i>=1;i--) {
				flag = false;
				for(int j=i-1;j>=1;j--) {
					if(arr[i]>arr[j]) {
						flag = true;
						break;
					}
				}
				if(flag == false) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
