import java.io.*;
import java.util.*;
class Main {
	static int T, A, B;
	static boolean visit[];
	static String command[];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();

    	T = Integer.parseInt(br.readLine());
    	for(int i=1;i<=T;i++) {
    		st = new StringTokenizer(br.readLine());
    		A = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    		Queue<Integer> q = new LinkedList<>();
    		
    		visit = new boolean[10000];
    		command = new String[10000];
    		visit[A] = true;
    		q.add(A);
    		Arrays.fill(command, "");
    		
    		while(!visit[B] && !q.isEmpty()) {
    			int original = q.poll();
    			int D = (original *2)%10000;
    			int S = original == 0 ? 9999 : original-1;
    			int L = (original%1000)*10 + original/1000; 
    			int R = (original%10)*1000+ original/10;
    			if(!visit[D]) {
    				visit[D] = true;
    				command[D]=command[original]+"D";
    				q.add(D);
    			}
    			if(!visit[S]) {
    				visit[S] = true;
    				command[S]=command[original]+"S";
    				q.add(S);
    			}
    			if(!visit[L]) {
    				visit[L] = true;
    				command[L]=command[original]+"L";
    				q.add(L);
    			}
    			if(!visit[R]) {
    				visit[R] = true;
    				command[R]=command[original]+"R";
    				q.add(R);
    			}
    			
    		}
    		sb.append(command[B]+"\n");
    	}
    	System.out.println(sb);
    }
}
