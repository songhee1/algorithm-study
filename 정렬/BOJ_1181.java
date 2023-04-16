package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1181 {
    static int n;
    static String arr[];
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        n=Integer.parseInt(br.readLine());
        arr=new String [n];

        for(int i=0;i<n;i++){
            String s=br.readLine();
            arr[i]=s;
        }
        Arrays.sort(arr, (e1,e2)->{
            if(e1.length()==e2.length()) return e1-e2;
            else return(e1.length())-(e2.length());
        });

        for(int a:arr){

        }
    }   
}
