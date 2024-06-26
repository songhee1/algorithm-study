import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Main {
	static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, arr[][], time = 0, count = 0;
	static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	static List<XY> list = new ArrayList<>();
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j] != 0) {
    				list.add(new XY(i, j));
    			}
    		}
    	}
    	
    	IceMelting();
	}
	private static void IceMelting() {
		while(!list.isEmpty()) {
			time++;
			count = 0;
			visit = new boolean[N][M];
			int newArr[][] = new int[N][M];
			for(int i=0;i<N;i++) {
				newArr[i] = arr[i].clone();
			}
			arr = checkIceHowManyOcean(newArr);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(arr[i][j]+" ");
					if(arr[i][j] != 0 && visit[i][j] == false) {
						BFS(i, j);
					}
				}
				System.out.println();
			}
			System.out.println("============");
			
			if(count<2) {
				System.out.println(time);
				return;
			}
		}
		System.out.println(0);
		return;
	}
	private static void BFS(int x, int y) {		
		count++;
		Queue<XY> q = new LinkedList<>();
		visit[x][y] = true;

		q.add(new XY(x, y));
		while(!q.isEmpty()) {
			XY now = q.poll();
			for(int i=0;i<dx.length;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0 || nx>=N ||ny<0||ny>=M) continue;
				if(visit[nx][ny] == true || arr[nx][ny] == 0) continue;
				visit[nx][ny] = true;
				q.add(new XY(nx, ny));
			}
		}
	}
	private static int[][] checkIceHowManyOcean(int newArr[][]) {
		List<XY> num = list;
		for(int j=0;j<num.size();j++) {
			XY xy = num.get(j);
			int sumOfOceans = 0;
			for(int i=0;i<dx.length;i++) {
				int nx = xy.x+dx[i];
				int ny = xy.y+dy[i];
				if(nx<0 || nx>=N ||ny<0||ny>=M) continue;
				if(newArr[nx][ny] == 0) {
					sumOfOceans++;
				}
			}
			
			if(newArr[xy.x][xy.y] < sumOfOceans) {
				newArr[xy.x][xy.y] = 0;
				list.remove(j);
			}else {
				newArr[xy.x][xy.y] -= sumOfOceans;
			}
		}
		return newArr;
	}
}
