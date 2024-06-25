import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Main {
	static int N, M, x, y, K;//세로, 가로, 좌표위치, 명령어 갯수
	static int arr[][], dir = 1; //1 동, 2서, 3북, 4남
	static int dx[] = {0,0,-1,1}, dy[] = {1,-1,0,0};
	static List<Integer> row = new ArrayList(Arrays.asList(0, 0, 0));
	static List<Integer> col = new ArrayList(Arrays.asList(0,0,0));
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	x = Integer.parseInt(st.nextToken());
    	y = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	while(st.hasMoreElements()) {
    		q.add(Integer.parseInt(st.nextToken())-1);
    	}
    	
    	MoveSquare();
    	
    	System.out.print(sb);
	}

	private static void MoveSquare() {
		while(!q.isEmpty()) {
			dir = q.poll();
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(!isValidPosition(nx, ny)) {
				continue;
			}
			
			x = nx;
			y = ny;
			
			changeSquare();
			checkMap();
			sb.append(row.get(1)+"\n");
		}
	}

	private static void checkMap() {
		if(arr[x][y] == 0) {
			arr[x][y] = col.get(2);
		}else {
			col.set(2,  arr[x][y]);
			arr[x][y] = 0;
		}
	}

	private static void changeSquare() {
		if(dir == 0) {
			int tmp = row.get(0);
			row.set(0, col.get(2));
			col.set(2, row.get(2));
			row.set(2, row.get(1));
			row.set(1, tmp);
		}else if(dir == 1) {
			int tmp = col.get(2);
			col.set(2, row.get(0));
			row.set(0, row.get(1));
			row.set(1, row.get(2));
			row.set(2, tmp);
		}else if(dir == 2) {
			int tmp = col.get(0);
			col.set(0, row.get(1));
			row.set(1, col.get(1));
			col.set(1, col.get(2));
			col.set(2, tmp);
		}else {
			int tmp = col.get(0);
			col.set(0, col.get(2));
			col.set(2, col.get(1));
			col.set(1, row.get(1));
			row.set(1, tmp);
		}
		
	}

	private static boolean isValidPosition(int nx, int ny) {
		if(nx<0 || nx>=N || ny<0 || ny>=M) return false;
		return true;
	}

}
