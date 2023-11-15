package com.edu.test;
import java.io.*;
import java.util.*;
public class SWEA_최빈수 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test =Integer.parseInt(br.readLine());
            
            int score[] = new int[101];
            st = new StringTokenizer(br.readLine(), " ");
            int max = 0;
            int num = 0;
            while(st.hasMoreTokens()){
            	int a = Integer.parseInt(st.nextToken());
                score[a]++;
                
                if(max<score[a]) {
                    max = score[a];
                	num = a;
                }
            }
			sb.append("#"+test_case).append(" ").append(num);
		}
        System.out.println(sb);
	}

}
