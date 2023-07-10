package com.edu.boj;
/*
 * nxn개의 수가 표에 채워져 있다.
 * (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하라
 * (x, y)는 x행, y열을 의미한다.
 * 
 * 표에 채워진 수와 합을 구하는 연산이 주어질 때 처리하는 프로그램 작성
 * 
 * 입력
 * 1 - 표의 크기 n, 구해야 하는 횟수 m(1<=n<=1024, 1<=m<=100,000)
 * 2~ x1,y1, x2,y2가 차례로 주어지며 (x1, y1)부터 (x2, y2) 의 합을 구해 출력
 * 
 *  0<표에 채워진 수 <=1,000
 *  x1<=x2, y1<=y2
 *  
 *  출력
 *  총 m개 줄에 걸쳐 (x1, y1)~(x2, y2) 까지의 합 출력
 */
import java.io.*;
import java.util.*;
public class BOJ_11660 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int n, m, x1, y1, x2, y2;
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n+1][n+1];
		int total = 0;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				total += Integer.parseInt(st.nextToken());
				arr[i][j] = total;
			}
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
		    y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append(arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1]).append("\n");
			
		}
		System.out.print(sb);

}
}
