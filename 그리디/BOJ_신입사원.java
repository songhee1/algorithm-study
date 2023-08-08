package greedy;
import java.io.*;
import java.util.*;
public class BOJ_신입사원 {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[][];
	public static void main(String[] args)throws Exception {
		int tc = Integer.parseInt(br.readLine());
		
		while(tc -- >0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (o1, o2)-> o1[0]-o2[0]);
			int count = 0;
			int minOrder = n;
			for(int i=0;i<n;i++) {
				minOrder = Math.min(minOrder, arr[i][1]);
				if(minOrder == arr[i][1]) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
