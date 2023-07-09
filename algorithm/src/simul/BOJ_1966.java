package simul;
/*
 * 큐 내부에 중요도를 확인합니다.
 * 현재 문서보다 중요도가 높은 문서가 하나라도 있으면 이 문서 인쇄하지 않고 큐의 
 * 가장 뒤에 재배치합니다.
 * 
 * 그렇지 않으면 바로 인쇄합니다.
 * 
 * 입력으로 큐에 있는 문서의 수와 중요도가 주어질때 어떤 문서가 몇번째로 인쇄되는지 
 * 알아내는게 문제
 * 
 * 입력
 * 문서의 개수 + 현재 큐에 몇번째에 놓여있는지 나타내는 정수
 * 
 * 출력
 * 해당 문서가 몇번째로 출력되는가를 출력
 */

import java.io.*;
import java.util.*;

class Docu{
	int posi;
	int value;
	Docu(int posi, int value){
		this.posi = posi;
		this.value = value;
	}
}
public class BOJ_1966 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int testcase, n, m;
	
	
	public static void main(String[] args) throws Exception {
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- >0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int count = 0;
			
			Queue <Docu> q = new LinkedList();
			int idx = 0;
			Integer []arr = new Integer [n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int value = Integer.parseInt(st.nextToken());
				q.add(new Docu(i, value));
				arr[idx++] = value;
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			int index = 0;
			
			while(!q.isEmpty()) {
			    Docu doc = q.poll();

				if(doc.value == arr[index]) {
					count++;
					if(doc.posi == m) {
						sb.append(count).append("\n");
						break;
					}
					index++;
				}else {
					q.add(doc);
				}
			}
			
		}
		System.out.println(sb);
		
	}

}
