import java.io.*;
import java.util.*;
class Main {
	static int N, M;
	static boolean visit[];
	static List<List<Integer>> list = new ArrayList<>();
	static boolean pass = false;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	for(int i=0;i<N;i++) {
    		list.add(new ArrayList<>());
    	}
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list.get(a).add(b);
    		list.get(b).add(a);
    	}
    	
    	for(int i=0;i<N;i++) {
    		visit = new boolean[N];
    		visit[i] = true;
    		DFS(i, 1, 0);
    		if(pass) {
    			System.out.println(1);
    			return;
    		}
    		visit[i] = false;
    	}
    	System.out.println(0);
    	
	}
	private static void DFS(int index, int friends, int relations) {
		if(pass) return;
		if(friends == 5 && relations == 4) {
			pass = true;
			return;
		}
		List<Integer> smallList = list.get(index);
		for(int i=0;i<smallList.size();i++) {
			int num = smallList.get(i);
			if(!visit[num]) {
				visit[num] = true;
				DFS(num, friends+1, relations+1);
				visit[num] = false;
			}
		}
	}
}
