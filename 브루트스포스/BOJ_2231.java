package 브루트스포스;

import java.util.*;
import java.io.*;

/*처음 생각한 아이디어
 * 1. a = n의 길이 + n의 길이만큼 1 생성(ex. n길이가 3이면 111) 라고 가정
 * 2. b = Math.floor(n/a)
 * 3. 자리수 큰 것부터 작은 자리수까지 for문으로 1~9까지 순회하면서 n과 같은 것 찾아서 반환
 */

public class BOJ_2231 {
    static int n;
    static double answer[];
    static double a, b;

    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        
        String make1="";
        
        n=Integer.parseInt(br.readLine());

        for(int i=1;i<=3;i++)make1+="1";
        a=(int)(Math.log10(n)+1)+Integer.parseInt(make1);

        b=Math.floor(n/a);
        answer=new double [n];

        for(int i=0;i<n;i++)    Arrays.fill(answer,b);
        
        for(double i=b;i<9;i++){
            answer[0]=i;
            for(double j=1;j<9;j++){
                if(i==b) j=b;
                else{
                    answer[1]=j;
                }
                for(double k=1;k<9;k++){
                    if(i==b) k=b;
                    else{
                        answer[2]=k;
                    }                   
                }
            }
        }
        
        bw.close();
        br.close();
    }
}
