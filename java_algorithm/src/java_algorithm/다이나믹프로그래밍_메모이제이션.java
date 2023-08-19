package java_algorithm;
import java.io.*;
import java.util.*;
public class 다이나믹프로그래밍_메모이제이션 {
	public static long memo[];
	public static void main(String[] args) {
		memo = new long[101];
		System.out.println(find(100));
		
	}
	public static long find(int n) {
		if(n == 1 || n == 2) {
			return memo[n] = 1;
		}
		
		if(memo[n] == 0) {
			if(memo[n-1] == 0) memo[n-1] = find(n-1);
			if(memo[n-2] == 0) memo[n-2] = find(n-2);
			return memo[n] = memo[n-1]+memo[n-2];
		}else {
			return memo[n];
		}
	}

}
