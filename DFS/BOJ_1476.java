package simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜 계산
 * 수 3개를 이용해 연도를 나타낸다. 지구, 태양, 그리고 달을 나타낸다.
 * 
 * 지구를 나타내는 수 : e, 태양 나타내는 수 s, 달 나타내는 수  m
 * 1<=e<=15, 1<=s<=28, 1<=m<=19
 * 
 * 1년 = 1 1 1
 * 1년 지날 때마다 세 수는 모두 1씩 증가
 * 어떤 수가 범위 넘어가는 경우 1이 된다.
 * 
 * e,s,m이 주어질 때 가장 빠른 년도를 출력한다.
 */
public class BOJ_1476 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int e1 = 1, s1=1, m1 =1;
		int year = 1;
		while(e1 != e || s1 !=s || m1 != m) {
			if(e1 == 15) {
				e1 = 1;
			}else e1++;
			if(s1 == 28) {
				s1 = 1;
			}else s1++;
			if(m1 == 19) {
				m1 = 1;
			}else m1++;
			
			year++;
		}
		
		System.out.print(year);
	}

}
