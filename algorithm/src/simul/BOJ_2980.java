package simul;
import java.io.*;
import java.util.*;
class Sinho{
	char color;
	int len;
	int posi;
	int rlen;
	int glen;
	Sinho(char color, int len, int posi, int rlen, int glen){
		this.color = color;
		this.len = len;
		this.posi = posi;
		this.rlen = rlen;
		this.glen = glen;
	}
}
public class BOJ_2980 {
/*
 * 빨간불이 지속되는 시간, 초록 불이 지속되는 시간을 미리 구함(빨간불과 초록불 불빛은 무한히 반복)
 * 상근이는 1초에 1미터를 움직이며 빨간색일 경우 멈추고 초록색이 될때까지 기다린다
 * 
 * 도로 끝까지 이동하는데 걸리는 시간을 구하라 도로의 시작은 0미터, 끝은 l미터
 * 
 * 입력
 * 신호등 개수n, 도로 길이 l
 * 각 신호등 정보 d,r,g(d = 신호등 위치, r = 빨간색, g = 초록색)이 지속되는 시간을 의미
 * 
 * 출력
 * 상근이가 도로 끝까지 이동하는데 걸리는 시간 출력
 */

/*
 * 내가 풀이한 방식
 * => 신호 클래스 생성(처음 색/위치/빨간불 시간/초록불 시간)
 * 입력 받을 때마다 신호 배열 생성해 신호를 각각 넣어주었다.
 * 
 * - state가 l이 되지 않으면 while을 반복해주도록 함
 * - while 진행 할때마다 time을 1씩 증가시켜주고 신호등 len도 증가시켜 rlen or glen과 같은지 비교
 * 같다면 해당 색으로 sinho의 color 변화
 * - 만약 빨간 불이 len이 다 되었다면 색을 초록불로 바뀌어주고 빨간불 len =0 지정
 * - 만약 초록 불이 len이 다 되었다면 색을 붉은불로 바뀌어주고 초록불 len =0 지정
 * 
 */
	static StringTokenizer st;
	static int n, l;
	static int d,r,g;
	static int state, time, sinhoidx;
	static int arr[];
	static Sinho sin[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[l+1];
		sin = new Sinho[100];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			sin[i] = new Sinho('r', 0, d, r,g);
		}
		
		while(state != l) {
			time++;

			boolean flag = false;
			for(int i=0;i<n;i++) {
				sin[i].len++;
				if(sin[i].color == 'g') {
					state++;
				}
				
				if(sin[i].color == 'r' && sin[i].len == sin[i].rlen) {
					sin[i].color = 'g';
					sin[i].rlen = 0;
				}else if(sin[i].color == 'g' && sin[i].len == sin[i].glen) {
					sin[i].color = 'r';
					sin[i].rlen = 0;
				}
				
				if(state<sin[i].posi && flag == false) {

					if(sin[i].color == 'g') {
						flag = true;
						state++;
					}
					break;
				}
			}
			
		}
		
		System.out.println(time);
	}

}
