import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	/*
	 * 빙산의 높이정보 : 양수, 바다 : 0(빈칸)
	 * 바다와 붙어있는 빙산은 동서남북 0개의 갯수만큼 줄어든다
	 * 빙산의 높이는 0이 최소높이
	 * 
	 * 빙산이 두 덩이 이상으로 분리되는 최초의 시간을 구하는 프로그램
	 * 전부 녹을때까지 두 덩이 이상 분리되지 않으면 0 출력
	 * 
	 * 전략 : 
	 * 1. arr를 돌면서 빙산인 곳 주변에 0 이 몇개 있는지 확인
	 *  -> 0의 갯수만큼 해당 빙산의 높이 차감
	 * 2. 시간 증가
	 * 3. 빙산을 돌면서 bfs에 들어갈때마다 빙산의 갯수 증가
	 * 4. 만약 빙산의 갯수가 두 덩이 이상이면 탈출
	 * 5. 아니면 반복
	 * */
    static StringBuilder sb = new StringBuilder();
    static int N, M, arr[][], time;
    static boolean visited[][];
    static int dx[] = {1,0,-1,0}, dy[]= {0,1,0,-1};
    static class Ice{
    	int x;
    	int y;
    	Ice(int x, int y){
    		this.x=x;
    		this.y=y;
    	}
    }
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        boolean hasIce = false;
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        boolean allmelted = false;
        int visit[][] = new int[N][M];
        while(checkIceNum()) {
        	
        	List<Ice>list = new ArrayList<>();
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			if(arr[i][j] > 0) {
        				visit[i][j]+=checkArounSea(i, j);
        				list.add(new Ice(i, j));
        			}
        		}
        	}
        	
        	List<Ice> rest = new ArrayList<>();
        	for(Ice ice : list) {
        		arr[ice.x][ice.y] -= visit[ice.x][ice.y];
        		if(arr[ice.x][ice.y] < 0) {
        			arr[ice.x][ice.y] = 0;
        		}else {
        			rest.add(ice);
        		}
        		visit[ice.x][ice.y] = 0;
        	}
        	
        	time++;
        	
        }
        
       System.out.println(time);

	}
	private static boolean checkIceNum() {
		int count = 0;
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] >0 && visited[i][j] == false) {
					bfs(new Ice(i, j));
					count++;
				}
			}
		}
		if(count>=2) {
			return false;
		}else if(count == 0) {
			time = 0;
			return false;
		}
		return true;
	}
	private static void bfs(Ice ice) {
		Queue<Ice> q = new LinkedList<>();
		q.add(ice);
		visited[ice.x][ice.y] = true;
		
		while(!q.isEmpty()) {
			Ice now = q.poll();
			for(int dir = 0;dir<dx.length;dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(visited[nx][ny] == false && arr[nx][ny] > 0) {
						q.add(new Ice(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	private static int checkArounSea(int i, int j) {
		int num = 0;
		for(int dir=0;dir<dx.length;dir++) {
			int nx = i+dx[dir];
			int ny = j+dy[dir];
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				if(arr[nx][ny] == 0) {
					num++;
				}
			}
		}
		return num;
	}
	
}
