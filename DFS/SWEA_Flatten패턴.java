import java.util.*;
import java.io.*;
class Solution{
	public static int dumpNumber;
	public static int mountain[], maxNum, minNum;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1;test_case<=10;test_case++) {
			
			//상자 높이 0~100까지 초기화
			mountain = new int[101];
			
			//덤프횟수 입력
			dumpNumber = Integer.parseInt(br.readLine());
			
			//상자 높이 100개 입력
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=1;i<=100;i++) {
				mountain[Integer.parseInt(st.nextToken())]++;
			}
			findMaxMin();
			dump(1);
			
			findMaxMin();
			if(mountain[0]!=0) sb.append(maxNum);
			else sb.append("#"+test_case+" ").append(maxNum - minNum).append("\n");
			
;		}
		
		System.out.print(sb);
	}
	
	public static void dump(int count) {
		if(count > dumpNumber) return;
		
		findMaxMin();
		
		mountain[maxNum]--;
		mountain[maxNum-1]++;
		mountain[minNum]--;
		mountain[minNum+1]++;
		
		dump(count+1);
	}
	public static void findMaxMin() {
		for(int i=1;i<=100;i++) {
			if(mountain[i] == 0) continue;
			minNum = i;
			break;
		}
		
		for(int i=100;i>=1;i--) {
			if(mountain[i] == 0) continue;
			maxNum = i;
			break;
		}
	}
}
