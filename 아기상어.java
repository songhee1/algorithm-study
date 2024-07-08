
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	static class Fish{
		int x;
		int y;
		int time;
		Fish(int x, int y, int time){
			this.x=x;
			this.y=y;
			this.time=time;
		}
	}
	static int N, storedTime = 0, atedNum = 0, size = 0;
	static int dx[] = {1,0,-1,0}, dy[]= {0,1,0,-1};
	static int arr[][], x, y;
	static boolean visit[][];
	static List<Fish> fishes = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 9) {
        			x = i; y =j;
        		}
        	}
        }
        while(true) {
        	visit = new boolean[N][N];
            
        	bfs(x, y);
            if(fishes.size() == 0) {
            	System.out.println(storedTime);
            	return;
            }else if(fishes.size() != 1) {
            
	            fishes.sort((o1, o2)->{
	            	if(o1.time == o2.time) {
	            		if(o1.x == o2.x) {
	            			return o1.y-o2.y;
	            		}else {
	            			return o1.x-o2.x;
	            		}
	            	}else {
	            		return o1.time-o2.time;
	            	}
	            });
            }
	            
            Fish now = fishes.get(0);
            System.out.println(now.x+", "+now.y);
            arr[now.x][now.y] = 9;
            arr[x][y] = 0;
            x = now.x; y = now.y;
            storedTime += now.time;
            atedNum++;
            
            
            if(atedNum == size) {
            	size++;
            }
            fishes.clear();
        }
        
	}
	private static void bfs(int i, int j) {
		Queue<Fish> q = new LinkedList<>();
		q.add(new Fish(i, j, 0));
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			Fish now = q.poll();
			for(int dir=0;dir<dx.length;dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visit[nx][ny] == false && arr[nx][ny]<= size) {
					if(arr[nx][ny]<size && arr[nx][ny] != 0) {	
						fishes.add(new Fish(nx, ny, now.time+1));

						System.out.println(arr[nx][ny]);
					}
					q.add(new Fish(nx, ny, now.time+1));
					
					visit[nx][ny] = true;
				}
			}
		}
	}
	
}
