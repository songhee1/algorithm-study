package com.edu.boj;
/*
 * nxn���� ���� ǥ�� ä���� �ִ�.
 * (x1, y1)���� (x2, y2)���� ���� ���ϴ� ���α׷��� �ۼ��϶�
 * (x, y)�� x��, y���� �ǹ��Ѵ�.
 * 
 * ǥ�� ä���� ���� ���� ���ϴ� ������ �־��� �� ó���ϴ� ���α׷� �ۼ�
 * 
 * �Է�
 * 1 - ǥ�� ũ�� n, ���ؾ� �ϴ� Ƚ�� m(1<=n<=1024, 1<=m<=100,000)
 * 2~ x1,y1, x2,y2�� ���ʷ� �־����� (x1, y1)���� (x2, y2) �� ���� ���� ���
 * 
 *  0<ǥ�� ä���� �� <=1,000
 *  x1<=x2, y1<=y2
 *  
 *  ���
 *  �� m�� �ٿ� ���� (x1, y1)~(x2, y2) ������ �� ���
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
