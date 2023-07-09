package simul;
import java.io.*;
import java.util.*;

public class BOJ_2980re {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, l;
	public static int d, r, g;
	public static int time, pre;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		while(n-- >0) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			time += d - pre; // 현재 위치에서부터 신호등까지의 거리 계산
			pre = d; //현재 위치 갱신(해당 신호등 위치로 이동)
			
			int next = time % (r+g); // 처음~ 현재까지의 위치에 오기까지
			//걸린 시간을 빨간불과 초록불의 주기로 나눠준 나머지 계산
			
			if(next < r) {
				time += r - next;
			}
		}
		
		time += l - d;
		System.out.println(time);
	}

}
