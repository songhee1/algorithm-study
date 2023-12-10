import java.util.*;
import java.io.*;
class Main{
	static String arr[][], copyArr[][];
	static int N, M, cctvsaGak = Integer.MAX_VALUE;
	static boolean v[];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0, 1,0,-1};
	static List<Pair> list;
	static class Pair{
		int x;
		int y;
		String number;
		Pair(int x, int y, String number){
			this.x=x;
			this.y=y;
			this.number = number;
		}
	}
	static class XY{
		int x;
		int y;
		XY(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		arr = new String[N][M];
		
		for(int i=0;i<N;i++) {
			String []s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j] = s[j];
				if(!arr[i][j].equals("0") && !arr[i][j].equals("6"))
					list.add(new Pair(i, j, arr[i][j]));
			}
		}
		v = new boolean[list.size()];
		
		find(0, new ArrayList<>());
		
		System.out.println(cctvsaGak);
	}
	public static void find(int cnt, List<Integer> subList) {
		if(cnt == list.size() ) {
			int sum = check(subList);
			cctvsaGak = Math.min(cctvsaGak, sum);
			return;
		}
		
		for(int i=0;i<4;i++) { // 상우하좌 결정
			subList.add(i);
			find(cnt+1, subList);
			subList.remove(subList.size()-1);
		}
	}
	private static int check(List<Integer> subList) {
		copyArr = new String[arr.length][];
		for(int i=0;i<arr.length;i++) {
			copyArr[i] = arr[i].clone();
		}
		for(int i=0;i<list.size();i++) {
			int direction = subList.get(i);
			if(direction == 0) {
				if(list.get(i).number.equals("1")) { // 1번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 0, copyArr); //위쪽으로 이동
				}else if(list.get(i).number.equals("2")) { //2번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 3, copyArr); //왼쪽으로 이동
					bfs(list.get(i).x, list.get(i).y, 1, copyArr); // 오른쪽으로 이동
				}else if(list.get(i).number.equals("3")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
				}else if(list.get(i).number.equals("4")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}else if(list.get(i).number.equals("5")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}
			}else if(direction == 1) {
				if(list.get(i).number.equals("1")) { // 1번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 1, copyArr); 
				}else if(list.get(i).number.equals("2")) { //2번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 0, copyArr); //왼쪽으로 이동
					bfs(list.get(i).x, list.get(i).y, 2, copyArr); // 오른쪽으로 이동
				}else if(list.get(i).number.equals("3")) {
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
				}else if(list.get(i).number.equals("4")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
				}else if(list.get(i).number.equals("5")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}
			}else if(direction == 2) {
				if(list.get(i).number.equals("1")) { // 1번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 2, copyArr); 
				}else if(list.get(i).number.equals("2")) { //2번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 1, copyArr); //왼쪽으로 이동
					bfs(list.get(i).x, list.get(i).y, 3, copyArr); // 오른쪽으로 이동
				}else if(list.get(i).number.equals("3")) {
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}else if(list.get(i).number.equals("4")) {
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}else if(list.get(i).number.equals("5")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}
			}else if(direction == 3) {
				if(list.get(i).number.equals("1")) { // 1번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 3, copyArr); 
				}else if(list.get(i).number.equals("2")) { //2번 cctv일때
					bfs(list.get(i).x, list.get(i).y, 0, copyArr); //왼쪽으로 이동
					bfs(list.get(i).x, list.get(i).y, 2, copyArr); // 오른쪽으로 이동
				}else if(list.get(i).number.equals("3")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}else if(list.get(i).number.equals("4")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}else if(list.get(i).number.equals("5")) {
					bfs(list.get(i).x, list.get(i).y, 0, copyArr);
					bfs(list.get(i).x, list.get(i).y, 1, copyArr);
					bfs(list.get(i).x, list.get(i).y, 2, copyArr);
					bfs(list.get(i).x, list.get(i).y, 3, copyArr);
				}
			}
			
			
			
		}
		
		return findSagak(copyArr);
	}
	
	private static int findSagak(String [][]copyArr) {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyArr[i][j].equals("0")) {
					sum ++;
				}
			}
		}
		
		return sum;
	}
	public static void bfs(int x, int y, int direc, String [][]copyArr) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(x, y));
		
		while(!q.isEmpty()) {
			XY now = q.poll();
			int nx = now.x+dx[direc];
			int ny = now.y+dy[direc];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(copyArr[nx][ny].equals("6")) continue;
			if(!copyArr[nx][ny].equals("0")) {
				q.add(new XY(nx, ny));
			}else {
				copyArr[nx][ny] = "#";
				q.add(new XY(nx, ny));
			}
		}
	}
	
}
