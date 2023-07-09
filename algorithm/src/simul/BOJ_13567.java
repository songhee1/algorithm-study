package simul;
import java.io.*;
import java.util.*;
/*
 * 로봇은 (0,0)에 위치해있고 방향은 동쪽 방향을 향하고 있다.
 * 로봇은 명령에 따라 정사각형 영역 s에서 움직이며, s의 왼쪽 아래 꼭짓점은 (0,0), 오른쪽 위 꼭짓점은 (m,m)이다.
 * 
 * 명령어 = 행할 동작 + 동작과 관련된 값
 * 동작은 두 가지이다. TRUN, MOVE
 * TRUN 0 : 현재 위치에서 왼쪽 90도 회전, TURN 1: 현재 위치에서 오른쪽 90도 회전을 의미한다.
 * MOVE d : 로봇이 향하고 있는 방향으로 d만큼 움직인다.(d는 양수)
 * 
 * 명령 수행 후 로봇이 s 경계 또는 내부에 있으면 명령어는 유효하다.
 * 
 * 
 * 입력
 * 1 - m n (m은 정사각형 s의 한 변의 길이 = s의 맨 오른쪽 꼭짓점 좌표는 m,m이다_
 * (n은 로봇이 수행할 n개의 명령어)
 * n - 명령어 (TRUN+dir , MOVE+d)
 * dir은 0 ,1 이고 d는 1000이하의 양의 정수이다.
 * 
 * 출력
 * 명령어 수행 후 명령어 열이 유효하면 정수 출력
 * 유효하지 않으면 -1 출력
 */
public class BOJ_13567 {
	public static StringTokenizer st;
	public static int m, n;
	//                         북  서  남  동
	public static int dirX[] = {0,-1, 0, 1};
	public static int dirY[] = {1, 0, -1, 0};
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		String order = "";
		int num = 0;
		int dir = 3;
		boolean flag = false;
		
		Pair pair = new Pair(0,0);
		
		while(n-- >0) {
			st = new StringTokenizer(br.readLine());
			
			order  = st.nextToken();
			num = Integer.parseInt(st.nextToken());
			
			if(order.equals("TURN")) {
				if(num == 0) {
					if(dir == 3) {
						dir = 0;
					}else {
						dir += 1;
					}
				}else if(num == 1) {
					if(dir == 0) {
						dir = 3;
					}else {
						dir -= 1;
					}
				}
			}else if(order.equals("MOVE")) {
				pair.x += num*dirX[dir];
				pair.y += num*dirY[dir];
			}
			
			if(pair.x <0 || pair.y <0 || pair.x > m || pair.y > m) {
				flag = true;
			}
		}
		
		if(flag == false){
			sb.append(pair.x).append(" ").append(pair.y);
		}else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}

}
