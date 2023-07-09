package simul;
/*
 * 명령 4가지(F: 한 눈금 앞으로, B: 한 눈금 뒤로, L: 왼쪽으로 90도 회전, R: 오른쪽 90도 회전)
 * 
 * 거북이가 이동한 영역을 계산한다.
 * 지나간 영역을 모두 포함하는 가장 작은 직사각형 넓이를 구하는 프로그램 작성
 * 
 * 거북이는 처음에 0,0 에 위치, 북쪽을 쳐다본다.
 */
import java.io.*;
import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Position{
	int dir;
	Pair pair;
	Position(int dir, Pair pair){
		this.dir = dir;
		this.pair = pair;
	}
}
public class BOJ_8911 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int testcase;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- >0) {
			String s = br.readLine();
			int rowMax = 0, rowMin = 0,
					colMax = 0, colMin = 0;
			
			Position p = new Position(0, new Pair(0,0));
			
			
			char ch = ' ';
			
			for(int i=0;i<s.length();i++) {
				
				ch = s.charAt(i);
				
				if(ch == 'F') {
					if(p.dir == 0) {
						++p.pair.y;
					}else if(p.dir == 1) {
						--p.pair.y;
					}else if(p.dir == -1) {
						--p.pair.x;
					}else if(p.dir == 2) {
						++p.pair.x;
					}
					
					rowMax = Math.max(rowMax, p.pair.x);
					rowMin = Math.min(rowMin,p.pair.x);
					colMax = Math.max(colMax, p.pair.y);
					colMin = Math.min(colMax, p.pair.y);
					
				}else if(ch == 'B') {
					if(p.dir == 0) {
						p.pair.y--;
					}else if(p.dir == 1) {
						p.pair.y++;
					}else if(p.dir == -1) {
						p.pair.x++;
					}else if(p.dir == 2) {
						p.pair.x--;
					}
					rowMax = Math.max(rowMax, p.pair.x);
					rowMin = Math.min(rowMin, p.pair.x);
					colMax = Math.max(colMax, p.pair.y);
					colMin = Math.min(colMax, p.pair.y);
					
				}else if(ch == 'L') {
					if(p.dir == 0) {
						p.dir = -1;
					}else if(p.dir == 1) {
						p.dir = 2;
					}else if(p.dir == -1) {
						p.dir = 1;
					}else if(p.dir == 2) {
						p.dir = 0;
					}
				}else if(ch == 'R') {
					if(p.dir == 0) {
						p.dir = 2;
					}else if(p.dir == 1) {
						p.dir = -1;
					}else if(p.dir == -1) {
						p.dir = 0;
					}else if(p.dir == 2) {
						p.dir = 1;
					}
				}
				
			}
			sb.append(Math.abs(rowMax-rowMin)*Math.abs(colMax-colMin)).append("\n");	
		
		}
		
		System.out.println(sb);
	}

}
