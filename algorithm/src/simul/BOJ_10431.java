package simul;
/*
 * 줄 서는 방법
 * 1. 자기보다 키 큰 학생이 없으면 그냥 그 자리에 서고 차례가 끝난다
 * 2. 자기보다 키큰 학생이 한명 이상 있으면 가장 앞에 선 학생 바로 앞에 선다.
 * 그 뒤에 있는 모든 학생들은 공간을 만들기 위해 한 발짝씩 뒤로 물러서게 된다.
 * 
 * 1,2 과정 반복을 통해 오름차순 정렬이 가능하다.
 * 총 몇 번 뒤로 물러서게 되는가?
 * 
 * 입력
 * 1 - 테스트케이스 수 (1<=p<=1000)
 * 2- 테스트 케이스 번호 + 20개의 양의 정수(아이들의 키)
 * 
 * 출력
 * 1 - 테스트 케이스 번호 + 학생들이 뒤로 물러난 걸음 수의 총합
 */
import java.io.*;
import java.util.*;
public class BOJ_10431 {
	public static StringTokenizer st;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testcase;i++) {
			st = new StringTokenizer(br.readLine());
			
			int test = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new LinkedList<>();
			int walkNum = 0;
			
			int initialSize = 0;
			
			for(int j=1;j<21;j++) {
				int input = Integer.parseInt(st.nextToken());
				boolean flag = false;
				if(list.size() == 0) {
					list.add(input);
				}else {
					for(int k=0; k<initialSize;k++) {
						if(input < list.get(k)) {
							list.add(k, input);
							walkNum += list.size()-1-k;
							flag = true;
							break;
						}
					}
					if(flag == false) list.add(input);
				}
				
				initialSize = list.size();
				
			}
			
			sb.append(i+1).append(" ").append(walkNum).append("\n");
		}
		
		System.out.print(sb);
	}

}
