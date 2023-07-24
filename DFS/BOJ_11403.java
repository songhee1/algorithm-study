package simul;

import java.io.*;
import java.util.*;
/*
 * n-1개 동영상 쌍을 골라 어떤 영상에서 다른 동영상으로 가는 경로가 반드시 하나 존재하도록 했다,
 * 임의의 두 쌍 사이의 동영상의 USADO를 그 경로의 모든 연결들의 USADO 중 최솟값으로 하기로 했다.
 * 
 * k값을 정해 영상과 usado가 k 이상인 모든 동영상이 추천되도록 할 것이다. 
 * 
 * 입력
 * 1- n, q
 * n-1~ 두 동영상 쌍의 USADO가 주어진다. 
 * 
 * 
 * 가중치가 없는 방향 그래프 g가 주어질 때, 모든 정점에 대해 i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램
 * 입력
 * 1- 정점의 개수 n(1<=n<=100)
 * 2~ 인접 행렬
 * 
 * i,j = 1 = i에서 j로 가는 간선이 존재한다는 뜻, i,i= 항상 0
 * 
 * 출력
 * n개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력
 * i에서 j로 가는 길이가 양수인 경로가 있으면 1로 아니면 0 출력
 */
public class BOJ_11403 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int arr[][], anw[][];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		arr = new int [n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int k = 0; k < n ; k++) {
			for(int i = 0; i< n;i++) {
				for(int j = 0; j<n ; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						System.out.println(i+", "+k+", "+j);
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
