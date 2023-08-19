package java_algorithm;
import java.io.*;
import java.util.*;
public class BOJ_신입사원 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arr[][];
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n][2];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int []o1, int []o2) {
					return o1[0]-o2[0];
				}
			});
			
			int num = n;
			int minMeon = arr[0][1];
			for(int i = 1;i<n;i++) {
				if(minMeon<arr[i][1]) {
					num--;
				}
				
				if(minMeon>arr[i][1]) {
					minMeon = arr[i][1];
				}
				
			}
			
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}

}
