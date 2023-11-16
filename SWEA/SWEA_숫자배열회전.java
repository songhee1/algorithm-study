import java.util.*;
import java.io.*;
class Solution{
	static int arr[][], n;
	static int arr90[][], arr180[][], arr270[][]; 
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arr90 = new int[n][n];
			arr180 = new int[n][n];
			arr270 = new int[n][n];
			
			print90();
			print180();
			print270();
			
			sb.append("#"+test_case).append("\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sb.append(arr90[i][j]);
				}
				sb.append(" ");
				for(int j=0;j<n;j++) {
					sb.append(arr180[i][j]);
				}
				sb.append(" ");
				for(int j=0;j<n;j++) {
					sb.append(arr270[i][j]);
				}
				sb.append("\n");
			}
					
		}
		
		System.out.println(sb);
	}
	public static void print90() {
		int k=0; int l = 0;
		for(int j=0;j<n;j++) {
			for(int i=n-1;i>=0;i--) {
				arr90[k][l] = arr[i][j];
				l++;
			}
			k++;
			l = 0;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr90[i][j]);
			}
			System.out.println();
		}
	}
	public static void print180() {
		int k=0; int l = 0;
		for(int i=n-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				arr180[k][l] = arr[i][j];
				l++;
			}
			k++;
			l = 0;
		}
	}
	public static void print270() {
		int k=0; int l = 0;
		for(int j=n-1;j>=0;j--) {
			for(int i=0;i<n;i++) {
				arr270[k][l] = arr[i][j];
				l++;
			}
			k++;
			l = 0;
		}
	}

}
