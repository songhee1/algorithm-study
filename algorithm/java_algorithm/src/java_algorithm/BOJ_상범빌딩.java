package java_algorithm;
import java.io.*;
import java.util.*;
class Pair{
	int floor;
	int x;
	int y;
	Pair(int floor, int x, int y){
		this.floor = floor;
		this.x = x;
		this.y = y;
	}
}
public class BOJ_상범빌딩 {
	public static List<char[][]> list = new LinkedList<>();
	public static int[][][] dlist;
	public static int minE = Integer.MAX_VALUE;
	public static Queue<Pair> q = new LinkedList<>();
	public static int L, R, C;
	public static StringBuilder sb = new StringBuilder();
	public static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			minE = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			char [][]di = new char[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					di[i][j] = '#';
				}
			}

			list.add(di);
			
			dlist = new int[L+2][R][C];
			
			
			for(int h = 1;h<=L;h++) {
				char [][]arr = new char[R][C];
				
				for(int i=0;i<R;i++) {
					String s = br.readLine();
					for(int j=0;j<C;j++) {
						arr[i][j] = s.charAt(j);
						if(arr[i][j] == 'S') {
							q.add(new Pair(h, i, j));
						}
					}
					
				}
				String a = br.readLine();
				list.add(arr);
	
			}
			
			char [][]di2 = new char[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					di2[i][j] = '#';
				}
			}
			
			list.add(di2);
			
			find();
			
//			for(int i=1;i<=L;i++) {
//				for(int j=0;j<R;j++) {
//					for(int k=0;k<C;k++) {
//						System.out.print(dlist[i][j][k]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			
			q.clear();
			
			
			if(minE == Integer.MAX_VALUE) {
				sb.append("Trapped!").append("\n");
			}else {
				sb.append("Escaped in "+minE
						+" minute(s).").append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void find() {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(dlist[p.floor-1][p.x][p.y] == 0 
					&& list.get(p.floor-1)[p.x][p.y] != '#') {
				dlist[p.floor-1][p.x][p.y] = dlist[p.floor][p.x][p.y] + 1;
				q.add(new Pair(p.floor-1, p.x, p.y));
				
				if(list.get(p.floor-1)[p.x][p.y] == 'E') {
					minE = Math.min(dlist[p.floor-1][p.x][p.y], minE);
					return;
				}
			}
			
			if(dlist[p.floor+1][p.x][p.y] == 0 
					&& list.get(p.floor+1)[p.x][p.y] != '#') {
				dlist[p.floor+1][p.x][p.y] = dlist[p.floor][p.x][p.y] + 1;
				q.add(new Pair(p.floor+1, p.x, p.y));
				
				if(list.get(p.floor+1)[p.x][p.y] == 'E') {
					minE = Math.min(dlist[p.floor+1][p.x][p.y], minE);
					return;
				}
			}
			
			for(int dir = 0;dir<4;dir++) {
				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];
				
				if(nx<0 || nx>=R || ny<0 || ny>=C) {
					continue;
				}
				
				if(dlist[p.floor][nx][ny] == 0 && list.get(p.floor)[nx][ny] != '#') {
					dlist[p.floor][nx][ny] = dlist[p.floor][p.x][p.y] + 1;
					q.add(new Pair(p.floor, nx, ny));
					
					if(list.get(p.floor)[nx][ny] == 'E') {
						minE = Math.min(dlist[p.floor][nx][ny], minE);
						return;
					}
				}
			}
		}
	}
}
