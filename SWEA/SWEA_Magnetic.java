import java.util.*;
import java.io.*;
class Solution{
	static int arr[][] = new int[100][100];
	static int count = 0;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=10;test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0;j<100;j++) {
				boolean hasAOne = false;
				boolean hasCohesion = false;
				for(int i=0;i<100;i++) {
					if(arr[i][j] == 2) {
						if(hasCohesion) continue;
						if(hasAOne) {
							System.out.println(i+", "+j);
							count++;
							hasCohesion = true;
							hasAOne = false;
						}
					}
					else if(arr[i][j] == 1) {
						hasAOne = true;
						hasCohesion = false;
					}
				}
				
			}
			
			sb.append("#"+test_case+" "+count).append("\n");
			count = 0;
		}
		
		System.out.println(sb);
	}
}
