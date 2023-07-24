package simul;
import java.io.*;
import java.util.*;
public class SW_5212 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int arr[][], num, kcal, maxScore;
	public static void main(String[] args) throws Exception {
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=1;i<testcase+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			num = Integer.parseInt(st.nextToken());
			kcal = Integer.parseInt(st.nextToken());
			
			arr = new int[num][2];
			maxScore = 0;
			
			for(int j=0;j<num;j++) {
				st = new StringTokenizer(br.readLine());
				
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
				
			}
			
			find(0,0,0);
			
			sb.append("#").append(i).append(" ").append(maxScore).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void find(int idx, int score, int kcalori) {
		
		if(kcalori>kcal) {
			return;
		}
		
		if(idx == num) {
			if(kcalori>kcal) return;
			
			maxScore = Math.max(score, maxScore);
			return;
		}
		
		find(idx+1, score+arr[idx][0], kcalori+arr[idx][1]);
		find(idx+1, score, kcalori);
	}
}
