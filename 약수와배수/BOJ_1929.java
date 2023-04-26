package 약수와배수;
import java.io.*;
import java.util.*;
 
public class BOJ_1929 {
	public static boolean[] prime;
	static int n,m;
	/*
	 * 에라토스테네스의 체
	 * 2부터 m 제곱근까지 각 수의 배수들 prime true로 변경
	 * 만약 2부터 m 제곱근에 해당하는 prime값이 true라면 continue
	 * 시간 : 232ms
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		prime=new boolean[m+1];
		prime[0]=true;
		prime[1]=true;

		is_prime();

		for(int i=n;i<=m;i++){
			if(!prime[i]) sb.append(i).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	static void is_prime(){
		for(int i=2;i<=Math.sqrt(m);i++){
			if(prime[i]) continue;
			for(int j=i*2;j<=m;j=j+i){
				prime[j]=true;
			}
		}
	}
}