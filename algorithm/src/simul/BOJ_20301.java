package simul;
/*
 * (n,k)-요세푸스 순열
 * k번째 앉은 사람을 제거하고, 이후 직전 제거된 사람의 오른쪽 k번째 사람을 계속 제거해 나간다.
 * 이 때 제거된 사람의 순서를 나타낸 것이 요세푸스 순열이다.
 * 
 * m명의 사람이 제거될 때마다 원을 돌리는 방향을 계속 바꾸려고 한다. 새로운 문제의 답을 
 * (n, k, m)-반전 요세푸스 순열이라고 한다.
 */
import java.io.*;
import java.util.*;
public class BOJ_20301 {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, k, m;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
	    Deque<Integer> dq = new LinkedList<>();
	    for(int i=1;i<n+1;i++) {
	    	dq.add(i);
	    }
	    
	    int dead = 0;
	    int dir = 1;
	    int num = 0;
	    while(dq.size() > 0) {
	    	num++;
	 
	    	if(dir == 1 && num == k) {
	    		sb.append(dq.pollFirst()).append("\n");
	    		dead++;
	    		num = 0;
	    	}else if(dir == -1 && num == k) {
	    		sb.append(dq.pollLast()).append("\n");
	    		dead++;
	    		num = 0;
	    	}else {
	    		if(dir == 1) dq.add(dq.pollFirst());
	    		else if(dir == -1) dq.addFirst(dq.pollLast());
	    	}
	    	
	    	if(dead == m) {
	    		if(dir == 1) {
	    			dir = -1;
	    		}else {
	    			dir = 1;
	    		}
	    		dead = 0;
	    	}
	    }
	    System.out.println(sb);
	}

}
