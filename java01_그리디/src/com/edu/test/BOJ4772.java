package com.edu.test;
import java.io.*;
import java.util.*;


public class BOJ4772 {
    public static String[]arr;
    public static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input = "";
        while((input=br.readLine()) != null && !input.isEmpty()){
            int inputInt = Integer.parseInt(input);
            int num = (int) Math.pow(3, inputInt);
            arr = new String[num];
            for(int i=0;i<num;i++) {
            	arr[i] = " ";
            }
            find(1, num, num);

            for(String a : arr){
                System.out.print(a);
            }
            sb.append("\n");
        }
//        System.out.println(sb);

    }
    //1 27 -> 1,9/19,27-> 1,3 + 7,9/19,21 + 25,27 -> 1,1+3,3+7,7+9,9/19,19
    public static void find(int start, int end, int num){
        if(num == 1){
            arr[start-1] = "-";
            return;	
        }
        int a = start+num/3-1;
        find(start, a, num/3);//1,1,길이는 1       
        find(start+(num/3)*2, end, num/3);//3,3, 길이는 1
    }
}
