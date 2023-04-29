package 브루트스포스;

import java.util.*;
import java.io.*;

/*처음 생각한 아이디어
 * 1. a = n의 길이 + n의 길이만큼 1 생성(ex. n길이가 3이면 111) 라고 가정
 * 2. b = Math.floor(n/a)
 * 3. 자리수 큰 것부터 작은 자리수까지 for문으로 1~9까지 순회하면서 n과 같은 것 찾아서 반환
 */

public class BOJ_2231 {
    static int n,numLength, startNum,sum;

    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
        String make="";
        
        n=Integer.parseInt(br.readLine());
        make+=n;
        numLength=n/10;
        
        startNum=10*numLength;
        for(int i=startNum;i<n;i++){
            sum=i;
            int mok=i/s
        }

        br.close();
    }
}
