//2
package java_algorithm;
import java.io.*;
import java.util.*;
public class BOJ_행렬_1080 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int arrA[][], arrB[][];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arrA = new int[n][m];
		arrB = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				arrA[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				arrB[i][j] = s.charAt(j) - '0';
			}
		}
		
		int num = 0;
		for(int i=0;i<=(n-1)-2;i++) {
			for(int j=0;j<=(m-1)-2;j++) {
				if(arrA[i][j] != arrB[i][j]) {
					num++;
					for(int h=i;h<i+3;h++) {
						for(int k=j;k<j+3;k++) {
							
							if(arrA[h][k] == 0) {
								arrA[h][k] = 1;
							}else {
								arrA[h][k] = 0;
							}
						}
					}
				}
			}
		}
		
		boolean flag = true;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arrA[i][j] != arrB[i][j]) {
					flag = false;
				}
			}
		}
		
		if(flag == true) {
			System.out.println(num);
		}else {
			System.out.println(-1);
		}
		
	}

}
