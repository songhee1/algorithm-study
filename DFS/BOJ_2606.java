import java.io.*;
import java.util.*;
class Main {
	static int N, count, totalCount;
	static boolean fact[];
	static List<List<Integer>> list = new ArrayList<>();;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();

    	N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    	count = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
    	fact = new boolean[N+1];
    	
    	for(int i=0;i<N+1;i++) {
    		list.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<count;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list.get(a).add(b);
    		list.get(b).add(a);
    	}
    	
    	find(1);
    	
    	System.out.println(totalCount);
    }
	private static void find(int num) {
		List<Integer> arr = list.get(num);
		fact[num] = true;
		for(int i=0;i<arr.size();i++) {
			int n = arr.get(i);
			if(!fact[n]) {
				totalCount++;
				find(n);
			}
		}
	}	
}
