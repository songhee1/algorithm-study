package simul;
import java.io.*;
import java.util.*;
/*
 * 홍준이는 미로의 모든 행과 열에 이동할 수 있는 칸을 걸어다녔다.
 * 자신의 움직임을 모두 노트에 적었다.
 * F: 한칸, L,R: 방향 왼쪽 오른쪽, 
 * .: 이동할 수 있는 칸, #: 벽
 */
public class BOJ_13335 {
	static StringTokenizer st;
	static int len, dir = 0; // 1 위, 0 아래, -1 왼, 2 오른쪽
	static int row = 50, col = 50;
	static int rowMin = Integer.MAX_VALUE, rowMax = Integer.MIN_VALUE,
			colMin=Integer.MAX_VALUE, colMax = Integer.MIN_VALUE;
	static char arr[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		len = Integer.parseInt(br.readLine());
		arr = new char[1000][1000];
		
		
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				arr[i][j]='#';
			}
		}
		
		arr[row][col]='.';
		
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			char a = s.charAt(i);
			if(a == 'L') {
			    if(dir == 0) dir = 2;
			    else if(dir == 1) dir = -1;
			    else if(dir == -1) dir = 0;
			    else if(dir == 2) dir = 1;
			}else if(a == 'R') {
				 if(dir == 0) dir = -1;
			    else if(dir == 1) dir = 2;
			    else if(dir == -1) dir = 1;
			    else if(dir == 2) dir = 0;
			}else if(a == 'F') {
				if(dir == 0) arr[++row][col]='.';
				else if(dir == 1) arr[--row][col]='.';
				else if (dir == -1) arr[row][--col]='.';
				else if(dir == 2) arr[row][++col]='.';
			}
		}
		
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				if(arr[i][j] == '.') {
					rowMin = Math.min(rowMin, i);
					rowMax = Math.max(rowMax, i);
					colMin = Math.min(colMin, j);
					colMax = Math.max(colMax, j);
				}
			}
		}
		
		for(int i=rowMin;i<=rowMax;i++) {
			for(int j=colMin;j<=colMax;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		

	}

}
