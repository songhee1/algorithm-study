package simul;
import java.io.*;
import java.util.*;
/*
 * 홍준이는 미로의 모든 행과 열에 이동할 수 있는 칸을 걸어다녔다.
 * 자신의 움직임을 모두 노트에 적었다.
 * F: 한칸, L,R: 방향 왼쪽 오른쪽, 
 * .: 이동할 수 있는 칸, #: 벽
 */
public class BOJ_13425 {
	static StringTokenizer st;
	static int len, dir = 0; // 1 위, 0 아래, -1 왼, 2 오른쪽
	static int row = 50, col = 50;
	static char arr[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static void main(String[] args) throws Exception {
		len = Integer.parseInt(br.readLine());
		arr = new char[1000][1000];
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
		
		

	}

}
