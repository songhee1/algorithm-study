package simul;
import java.io.*;
import java.util.*;
public class SW_1206 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int arr[], total;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		for(int i=1;i<11;i++) {
			int num = Integer.parseInt(br.readLine());
			
			arr = new int[num];
			total = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<num;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=2;j<num-2;j++) {
				int minNum = Integer.MAX_VALUE;
				boolean flag = false;
				
				if(arr[j-1] == 0 && arr[j-2] == 0 && arr[j+1] == 0 && arr[j+2] == 0) {
					minNum = arr[j];
					flag = true;
				}else if(arr[j-1]<arr[j] && arr[j-2]<arr[j] && arr[j+1]<arr[j] && arr[j+2]<arr[j]) {
					if(arr[j-1] != 0) {
						minNum = Math.min(arr[j]-arr[j-1], minNum);
						flag = true;
					}
					if(arr[j-2] != 0) {
						minNum = Math.min(arr[j]-arr[j-2], minNum);
						flag = true;
					}
					if(arr[j+1] != 0) {
						minNum = Math.min(arr[j]-arr[j+1], minNum);
						flag = true;
					}
					if(arr[j+2] != 0) {
						minNum = Math.min(arr[j]-arr[j+2], minNum);
						flag = true;
					}
					
				}
				if(flag == true) total += minNum;
				
			}
			
			sb.append("#"+i).append(" ").append(total).append("\n");
		}
		
		System.out.print(sb);
	}

}
