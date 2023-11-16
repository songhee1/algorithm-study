import java.util.*;
import java.io.*;
class Solution{
	static int dx[] = {1, 0};
	static int dy[] = {0, 1};
	static int n, k, arr[][];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[n+2][n+2];
			for(int i=1;i<n+1;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1;j<n+1;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					if(arr[i][j] == 1 && arr[i-1][j] == 0) {
						if(find(i+dx[0], j+dy[0], 0) + 1 == k) {
							System.out.println("아래: "+i+", "+j);
							System.out.println(find(i+dx[1], j+dy[1], 1) + 1);
							count++;
						}
					}
					if(arr[i][j] == 1 && arr[i][j-1] == 0) {
						System.out.println("오른쪽:"+i+", "+j);
						System.out.println(find(i+dx[1], j+dy[1], 1) + 1);
						if(find(i+dx[1], j+dy[1], 1) + 1 == k) {
							count++;
						}
					}
				}
			}
			
			sb.append("#"+test_case+" ").append(count).append("\n");
			
		}
		
		System.out.println(sb);
	}
	public static int find(int nx, int ny, int dir) {
		if(nx<=0 || nx>n || ny<=0 || ny>n) return 0;
		
		if(arr[nx][ny] == 1) {
			return 1+ find(nx+dx[dir], ny+dy[dir], dir);
		}
		return 0;
	}

}
