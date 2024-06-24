import java.io.*;
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
	static int arr[][], row = 0, col = 0, dir = 1, time = 0, N;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}; //북 동 남 서
	static Map<Integer, String> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][N];
    	
    	int K = Integer.parseInt(br.readLine());
    	for(int i=0;i<K;i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken())-1;
    		int y = Integer.parseInt(st.nextToken())-1;
    		arr[x][y] = 1;
    	}
    	
    	int L = Integer.parseInt(br.readLine());
    	for(int i=0;i<L;i++) {
    		st = new StringTokenizer(br.readLine());
    		map.put(Integer.parseInt(st.nextToken()), st.nextToken());
    	}
    	
    	gameStart();
	}
	private static void gameStart() {
		List<XY> list = new LinkedList<>();
		list.add(new XY(0, 0));
		arr[0][0] = 2;
		
		while(true) {
			row += dx[dir];
			col += dy[dir];
			
			time++;
			
			if(!isValid(row, col)) {
				System.out.println(time);
				return;
			}
			
			if(arr[row][col] == 1) {
				list.add(new XY(row, col));
			}else {
				list.add(new XY(row, col));
				XY beforeTail = list.remove(0);
				arr[beforeTail.x][beforeTail.y] = 0;
			}
			arr[row][col] = 2;
			
			if(map.containsKey(time)) {
				String op = map.get(time);
				if(op.equals("L")) {
					dir = (dir == 0 ? 3 : dir-1);
				}else {
					dir = (dir == 3 ? 0 : dir+1);
				}
			}
		}
	}
	private static boolean isValid(int newRow, int newCol) {
		if(newRow<0 || newRow>=N || newCol<0 || newCol>=N) return false;
		if(arr[newRow][newCol] == 2) return false;
		return true;
	}
	
}
