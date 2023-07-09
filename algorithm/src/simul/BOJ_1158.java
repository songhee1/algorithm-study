package simul;
/*
 * 요세푸스 문제
 * K번 사람을 우선 제거하고, 이후 직전 제거된 사람의 오른쪽 K번째 사람을 제거합니다.
 * 위 과정을 계속 반복해 나간다.
 * 이럴때 제거된 사람의 순서는 어떻게 되는가? 이 문제의 답은 (N,K)-요세푸스 순열이라고 한다.
 * 
 * (7,3)-요세푸스 순열은 <3,6,2,7,1,5,4>가 된다.
 */
import java.io.*;
import java.util.*;
public class BOJ_1158 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int n, k;
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Queue<Integer>q = new LinkedList<>();
		for(int i=1;i<n+1;i++) {
			q.add(i);
		}
		
		int num = 0;
		sb.append("<");
		while(q.size() > 1) {
			num++;
			if(num == k) {
				sb.append(q.poll()).append(", ");
				num = 0;
			}else {
				q.add(q.poll());
			}
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}
