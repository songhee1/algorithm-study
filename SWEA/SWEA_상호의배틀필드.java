import java.util.*;
import java.io.*;
class Solution{
	static char arr[][];
	static char user[] = {'^', 'v', '<', '>'}; //상하좌우
	static int H, W, nowX, nowY, usIdx = -1; //사용자의 위치(nowX, nowY)
	static String command;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			boolean hasCheck = false;
			arr = new char[H][W];
			for(int i=0;i<H;i++) {
				String s = br.readLine();
				for(int j=0;j<W;j++) {
					char ch = s.charAt(j);
					for(int k=0;k<user.length;k++) {
						if(user[k] == ch) {
							usIdx = k;
							nowX = i; nowY = j; 
							hasCheck = true;
							break;
						}
					}
					
					if(!hasCheck) {
						arr[i][j] = s.charAt(j); 
					}else {
						arr[i][j] = '.';
					}
					hasCheck = false;
				}
			}
			
			br.readLine();
			command = br.readLine();
			
			for(int i=0;i<command.length();i++) {
				switch(command.charAt(i)) {
				case 'S':
					findBrick();
					break;
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;
				}
				arr[nowX][nowY] = user[usIdx];
				System.out.println("================="+(i+1)+"번째 출력================");
				for(int k=0;k<H;k++) {
					for(int l=0;l<W;l++) {
						System.out.print(arr[k][l]);
					}
					System.out.println();
				}
				arr[nowX][nowY] = '.';
			}
			
			arr[nowX][nowY] = user[usIdx];
	
			sb.append("#"+test_case+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	public static void findBrick() {
		if(usIdx == 0) {
			for(int i=nowX-1;i>=0;i--) {
				if(arr[i][nowY] == '*') {
					arr[i][nowY] = '.';
					return;
				}else if(arr[i][nowY] == '#') return;
			}
		}else if(usIdx == 1) {
			for(int i=nowX+1;i<H;i++) {
				if(arr[i][nowY] == '*') {
					arr[i][nowY] = '.';
					return;
				}else if(arr[i][nowY] == '#') return;
			}
		}else if(usIdx == 2) {
			for(int j=nowY-1;j>=0;j--) {
				if(arr[nowX][j] == '*') {
					arr[nowX][j] = '.';
					return;
				}else if(arr[nowX][j] == '#') return;
			}
		}else if(usIdx == 3) {
			for(int j=nowY+1;j<W;j++) {
				if(arr[nowX][j] == '*') {
					arr[nowX][j] = '.';
					return;
				}else if(arr[nowX][j] == '#') return;
			}
		}
		
	}
	public static void move(int idx) {
		usIdx = idx;
		if(usIdx == 0) {
			if(nowX-1<0) return;
			if(arr[nowX-1][nowY] == '.') {
				nowX -=1;
			}
		}else if(usIdx == 1) {
			if(nowX+1 >=H) return;
			if(arr[nowX+1][nowY] == '.') {
				nowX +=1;
			}
		}else if(usIdx == 2) {
			if(nowY-1 <0 ) return;
			if(arr[nowX][nowY-1] == '.') {
				nowY -=1;
			}
		}else if(usIdx == 3) {
			if(nowY+1 >=W ) return;
			if(arr[nowX][nowY+1] == '.') {
				nowY +=1;
			}
		}
	}
	
}
