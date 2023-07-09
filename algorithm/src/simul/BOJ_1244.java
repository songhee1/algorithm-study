package simul;
import java.io.*;
import java.util.*;
/*
 * 스위치에는 1부터 연속적으로 번호가 붙어있다.
 * 스위치는 켜져있거나 꺼져있는 상태이다.
 * 1은 켜져있고 0은 꺼져있음을 나타낸다.
 * 
 * 성별과 받은 수에 따라 스위치를 조작하게 된다
 * 남학생 = 스위치번호가 자신이 받은 수의 배수 => 스위치 상태를 바꾼다.
 * 여학생 = 자신이 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아
 * 그 구간의 스위치 상태를 모두 바꾼다. 이때 구간에 속한 스위치 수는 항상 홀수다.
 * 만약 여학생이 받은 수를 중심으로 대칭인 스위치 상태가 없다면 그 수만 상태를 바꾼다.
 * 
 * 학생들은 입력 순서대로 스위치 상태를 바꾸었을때 마지막 상태를 출력하는 프로그램을 작성하세요
 * 
 * 입력
 * 1- 스위치 수 (100이하인 양의 정수)
 * 2 -스위치 상태
 * 3- 학생 수(100이하인 양의 정수)
 * 4~ 성별 + 받은 수(남자는 1, 여학생은 2)
 * 
 * 출력
 * 스위치의 마지막 상태를 출력하는 프로그램을 작성
 * 
 */
public class BOJ_1244 {
	public static StringTokenizer st;
	public static int num, arr[], snum, wm, swnum;
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		num = Integer.parseInt(br.readLine());
		
		arr = new int[num];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<num;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		snum = Integer.parseInt(br.readLine());
		
		while(snum -->0) {
			st = new StringTokenizer(br.readLine());
			wm = Integer.parseInt(st.nextToken());
			swnum = Integer.parseInt(st.nextToken());
			
			if(wm == 1) {
				for(int i=0;i<num;i++) {
					if((i+1)%swnum == 0) {
						if(arr[i] == 1) arr[i] = 0;
						else {
							arr[i] = 1;
						}
					}
				}
			}else {
				int inc = 1;
				int downNum = swnum-1;
				int upNum = swnum-1;
				
				if(arr[swnum-1] == 1) arr[swnum-1] = 0;
				else {
					arr[swnum-1] = 1;
				}
				
				while( true ) {
					downNum -= inc;
					upNum += inc;
					
					if(downNum <0 || upNum >= num) break;
					
					if(arr[downNum] != arr[upNum]) {
						break;
					}else {
						if(arr[downNum] == 1) {
							arr[downNum] = 0;
							arr[upNum] = 0;
						}
						else {
							arr[downNum] = 1;
							arr[upNum] = 1;
						}
					}
				}
				
			}
		}
		
		for(int i=0;i<num;i++) {
			if(i%20 == 0 && i != 0) sb.append("\n");
			sb.append(arr[i]).append(" ");
		}
		
		System.out.print(sb);
	}

}
