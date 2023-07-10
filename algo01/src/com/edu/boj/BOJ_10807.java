package com.edu.boj;
/*
 * �� n�� ������ �־����� �� ���� v�� �� ������ ���ϴ� ���α׷� �ۼ�
 * 
 * �Է�
 * 1-������ ���� n(1<=n<=100)
 * 2-������ �������� ����
 * 3-ã������ ����v�� �־�����
 * 
 * -100<= ������ v <=100
 * 
 * ���
 * n���� ���� �� v�� �� ������ ���϶�
 */
import java.io.*;
import java.util.*;
public class BOJ_10807 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int n, v, arr[];
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[201];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[Integer.parseInt(st.nextToken())+100]++;
		}
		
		v = Integer.parseInt(br.readLine());
		System.out.print(arr[v+100]);
	}

}
