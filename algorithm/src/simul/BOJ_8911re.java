package simul;
import java.io.*;
import java.util.*;
public class BOJ_8911re {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int testcase;
	//                         북  동  남  서
	public static int dirX[]= {0, 1,  0, -1};
	public static int dirY[]= {1, 0, -1, 0};
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- >0) {
			String s = br.readLine();
			
			int x = 0, y = 0, rowMin = 0, rowMax = 0, colMin = 0, colMax = 0;
			int dir = 0;
			for(int i=0;i<s.length();i++) {
				char ch = s.charAt(i);
				
				if(ch == 'F') {
					x += dirX[dir];
					y += dirY[dir];
				}else if(ch == 'B') {
					x -= dirX[dir];
					y -= dirY[dir];
				}else if(ch == 'L') {
					if(dir == 0) {
						dir = 3;
					}else {
						dir -= 1;
					}
				}else if(ch == 'R') {
					if(dir == 3) {
						dir = 0;
					}else {
						dir += 1;
					}
				}
				
				rowMin = Math.min(rowMin, x);
				rowMax = Math.max(rowMax, x);
				colMin = Math.min(colMin, y);
				colMax = Math.max(colMax, y);
			}
			
			sb.append(Math.abs(rowMax-rowMin)*Math.abs(colMax-colMin)).append("\n");
		}
		
		System.out.println(sb);
	}

}
