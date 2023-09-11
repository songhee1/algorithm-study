package com.edu.test;

import java.io.*;
import java.util.*;

public class BOJ_수리공항승 
{
 public static int arr[];
 public static boolean notCared[];
 // tip: arguments are passed via the field below this editor
 public static void main(String[] args) throws Exception
 {
     StringTokenizer st;
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     st = new StringTokenizer(br.readLine());
     int n = Integer.parseInt(st.nextToken());
     int l = Integer.parseInt(st.nextToken());

     int count = 0;
     arr = new int[n];
     notCared = new boolean[1001];
     st = new StringTokenizer(br.readLine());
     for(int i=0;i<n;i++){
         arr[i] = Integer.parseInt(st.nextToken());
         notCared[arr[i]] = true;
     }
     Arrays.sort(arr);
     
     for(int i=0;i<n;i++) {
    	 if(notCared[arr[i]] == true) {
    		 
    		 for(int j=arr[i]-l+1;j<=arr[i];j++) {
    			 if(j<=0) continue;
                 if(j>1000) continue;
    			 
    			 if(notCared[j] == true) {
    				 count++;
    				 for(int k=j;k<=j+(l-1);k++) {
    					 if(k>1000) break;
    					 notCared[k] = false;
    				 }
    				break;
    			 }
    		 }
    	 }
     }
     
     System.out.println(count);
     
 }
package com.edu.test;

import java.io.*;
import java.util.*;

public class BOJ_수리공항승 
{
 public static int arr[];
 public static boolean notCared[];
 // tip: arguments are passed via the field below this editor
 public static void main(String[] args) throws Exception
 {
     StringTokenizer st;
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     st = new StringTokenizer(br.readLine());
     int n = Integer.parseInt(st.nextToken());
     int l = Integer.parseInt(st.nextToken());

     int count = 0;
     arr = new int[n];
     notCared = new boolean[1001];
     st = new StringTokenizer(br.readLine());
     for(int i=0;i<n;i++){
         arr[i] = Integer.parseInt(st.nextToken());
         notCared[arr[i]] = true;
     }
     Arrays.sort(arr);
     
     for(int i=0;i<n;i++) {
    	 if(notCared[arr[i]] == true) {
    		 
    		 for(int j=arr[i]-l+1;j<=arr[i];j++) {
    			 if(j<=0) continue;
                 if(j>1000) continue;
    			 
    			 if(notCared[j] == true) {
    				 count++;
    				 for(int k=j;k<=j+(l-1);k++) {
    					 if(k>1000) break;
    					 notCared[k] = false;
    				 }
    				break;
    			 }
    		 }
    	 }
     }
     
     System.out.println(count);
     
 }
}