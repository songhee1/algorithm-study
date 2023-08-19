package DynamicProgramming;
import java.io.*;
import java.util.*;
public class 개미전사 {
	public static int memo[];
	public static void main(String[] args) throws Exception {
		memo = new int[4+2];
		int arr[] = {0,0,1,3,1,5};
		
		for(int i=2; i<4+2;i++) {
//			memo[i] = memo[i-2]+arr[i];
//			maxNum = Math.max(maxNum, memo[i]);
			
			memo[i] = Math.max(memo[i-1], memo[i-2]+arr[i]);
		}
		
		System.out.println(memo[5]);
	}

}
