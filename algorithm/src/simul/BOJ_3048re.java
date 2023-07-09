package simul;
import java.io.*;
import java.util.*;
class Ant{
	char ch;
	int value;
	Ant(char ch, int value){
		this.ch = ch;
		this.value = value;
	}
}
public class BOJ_3048re {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Ant ant1[], ant2[], ant[];
	public static int n1, n2;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		ant1 = new Ant[n1];
		ant2 = new Ant[n2];
		
		String s1 = br.readLine();
		for(int i=0;i<n1;i++) {
			ant1[i] = new Ant(s1.charAt(i), 1);
		}
		
		String s2 = br.readLine();
		for(int i=0;i<n2;i++) {
			ant2[i] = new Ant(s2.charAt(i), -1);
		}
		
		ant = new Ant[n1+n2];
		for(int i=0;i<n1;i++) {
			ant[i] = ant1[n1-1-i];
		}
		for(int i=n1;i<n1+n2;i++) {
			ant[i] = ant2[i-n1];
		}
		
		int time = Integer.parseInt(br.readLine());
		int clock = 0;
		
		while(clock != time) {
			clock++;
			Ant now[] = ant.clone();
			for(int i=0;i<n1+n2-1;i++) {
				if(now[i].value == 1 && now[i+1].value == -1) {
					Ant a = ant[i];
					ant[i] = ant[i+1];
					ant[i+1] = a;
				}
			}
		}
		
		for(int i=0;i<n1+n2;i++) {
			sb.append(ant[i].ch);
		}
		
		System.out.print(sb);
	}

}
