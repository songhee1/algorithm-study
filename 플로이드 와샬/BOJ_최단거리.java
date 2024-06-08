import java.io.*;
import java.util.*;
class Main {
	static int N, M, X; //사람 수, 단방향 도로 갯수, 모일 마을 번호
	static int dp[][];
	static int INF = 1000000000;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();

    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	X = Integer.parseInt(st.nextToken());
    	
    	dp = new int[N+1][N+1];
    	
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			if(i == j) {
    				dp[i][j] = 0;
    			}else {
    				dp[i][j] = INF;	
    			}
    		}
    	}
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int time = Integer.parseInt(st.nextToken());
    		
    		dp[start][end] = time;
    	}
    	
    	for(int k=1;k<=N;k++) {
    		for(int i=1;i<=N;i++) {
    			for(int j=1;j<=N;j++) {
    				dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
        			
    			}
    		}
    	}
    	
    	int maxValue = dp[1][X];
    	for(int i=2;i<=N;i++) {
    		if(maxValue<dp[i][X] && dp[i][X] != INF) {
    			maxValue = dp[i][X];
    		}
    	}
    	
    	System.out.println(maxValue);
    	
    }
	
}
