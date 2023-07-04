package simulation;
import java.io.*;
import java.util.*;
public class BOJ_3048 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n1, n2, n, idx, count;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class Ant{
		char val;
		int dir;
		Ant(char val, int dir){
			this.val=val;
			this.dir=dir;
		}
	}
	
	public static void main(String[] args)throws Exception {
		
		st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		n = n1+n2;
		
		Ant []grp1 = new Ant[n1];
		Ant []grp2 = new Ant[n2];
		
		String s1 = br.readLine();
		for(int i=n1-1;i>=0;i--) {
			grp1[i]=new Ant(s1.charAt(n1-i-1),1);
		}
		
		String s2 = br.readLine();
		for(int i=0;i<n2;i++) {
			grp2[i]=new Ant(s2.charAt(i),-1);
		}
		
		Ant[] start = new Ant[n1+n2];
		for(int i=0;i<n1;i++) {
			start[i]=grp1[i];
		}
		for(int i=n1;i<n1+n2;i++) {
			start[i]=grp2[i-n1];
		}
		
		int recur = Integer.parseInt(br.readLine());
		
		for(int i=0;i<recur;i++) {
			Ant[] copy = start.clone();
			for(int j=0;j<copy.length-1;j++) {
				if(copy[j].dir==1 && copy[j+1].dir == -1) {
					Ant tmp = start[j];
					start[j] = start[j+1];
					start[j+1] = tmp;
				}
			}
		}
		
		for(int i=0;i<start.length;i++) {
			sb.append(start[i].val);
		}
		
		System.out.println(sb);
		
	
	
	}
	

}
