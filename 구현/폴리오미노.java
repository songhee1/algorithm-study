import java.io.*;
import java.util.*;
class Solution {
	static int N, M, maxValue = 0;
	static int arr[][];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M]; // 행과 열
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			calc(i, j);
    		}
    	}
    	
    	System.out.println(maxValue);
	}
	private static void calc(int x, int y) {
		if(y+3<M) {
			int sum = 0;
			for(int i=1;i<4;i++) {
				sum += arr[x][y+i];
			}
			maxValue = Math.max(maxValue, sum);
		}
		if(y+1<M && x+1<N) {
			int sum = 0;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					sum += arr[x+i][y+j];
				}
			}
			maxValue = Math.max(maxValue, sum);
		}
		if(y+1<M && x+2<N) {
			int sum1 = 0;
			for(int i=0;i<3;i++) {
				sum1 += arr[x+i][y];
			}
			sum1 += arr[x+2][y+1];
			maxValue = Math.max(maxValue, sum1);
			
			int sum2 = 0;
			sum2 += arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y+1];
			maxValue = Math.max(maxValue, sum2);
		}
		
		if(y+2<M && x+1<N) {
			int sum = 0;
			for(int i=0;i<3;i++) {
				sum += arr[x][y+i];
			}
			sum += arr[x+1][y+1];
			maxValue = Math.max(maxValue, sum);
		}
		
	}
}
