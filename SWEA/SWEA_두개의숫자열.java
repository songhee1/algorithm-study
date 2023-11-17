import java.util.*;
import java.io.*;
class Solution{
	static int arrA[], arrB[];
	static int n, m, maxScore;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=tc;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arrA =  new int[n];
			arrB = new int[m];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<n;i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<m;i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			if(arrA.length<arrB.length) {
				find(arrA, arrB);
			}else {
				find(arrB, arrA);
			}
			
			sb.append("#"+test_case+" ").append(maxScore).append("\n");
			maxScore = 0;
			
		}
		
		System.out.println(sb);
	}
	public static void find(int arr1[], int arr2[]) {
		for(int i=0;i<=arr2.length-arr1.length;i++) {
			int sum = 0;
			for(int j=0;j<arr1.length;j++) {
				sum += (arr1[j] * arr2[i+j]);
				System.out.println(arr1[j]+", "+arr2[i+j]+"||"+arr1[j]*arr2[i+j]);
			}
			maxScore = Math.max(sum, maxScore);
		}
	}
}
