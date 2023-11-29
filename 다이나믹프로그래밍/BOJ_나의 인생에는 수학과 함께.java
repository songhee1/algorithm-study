import java.util.*;
import java.io.*;
class Solution{
	static String arr[][];
	static int dx[] = {1, 0}, n;
	static int dy[] = {0, 1}, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new String [n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		List<String> l = new ArrayList<>();
		l.add(arr[0][0]);
		find(0, 0, l);
		
		System.out.println(maxSum+" "+minSum);
	}
	public static void find(int x, int y, List<String> list) {
		if(x == n-1 && y == n-1) {
			int size = list.size();
			int sum = 0;
			int b = 0;
			String tmp = "";
			boolean check = false;
			int idx = 0;
			while(size-- > 0) {
				String s = list.get(idx++);
				if(s.equals("+") || s.equals("-") || s.equals("*")) {
					tmp = s;
					check = true;
				}else {
					if(check == true) {
						b = Integer.parseInt(s);
						if(tmp.equals("+")) sum+= b;
						else if(tmp.equals("-")) sum-=b;
						else sum*= b;
						
						check = false;
					}else {
						sum = Integer.parseInt(s);
					}
				}
			}
			
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}
		
		// 0 1
		for(int dir = 0;dir<=1;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx<0 || nx>=n|| ny<0|| ny>=n) continue;
			
			list.add(arr[nx][ny]);
			find(nx, ny, list);
			list.remove(list.size()-1); 
		}
		
	}
}
