package Greedy;
import java.io.*;
import java.util.*;
public class BOJ_카드정렬하기 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int look[];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int total = 0; 
		int pre = 0;
		int count = 0;
		look = new int[10000000];
		
		int minNum = 10000000;
		int maxNum = 1;
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			look[a]++;
			minNum = Math.min(minNum, a);
			maxNum = Math.max(maxNum, a);
		}
		for(int i=minNum;i<=maxNum;i++) {
			while(look[i]!= 0 ) {
				pre += i;
				look[i]--;
				
				count++;
				if(count == 2) {
					total += pre;
					look[pre]++;
					maxNum = Math.max(maxNum, pre);
					count = 0;
					pre = 0;
				}
			}
			
		}
		
		System.out.println(total);
	}

}
