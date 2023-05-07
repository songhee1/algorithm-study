package 브루트스포스;
import java.io.*;
import java.util.*;
public class BOJ_2231secondamend {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; //찾아야 하는 수
    static int sum; //분해합
    static boolean flag=false;

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        
        for(int i=1;i<n;i++){
            sum=i;
            int r=i;
            while(r!=0){
                sum += r%10;
                r=r/10;
            }
            if(sum == n) {
                sb.append(i);
                flag=true;
                break;
            }
        }

        if(flag == false) sb.append(0);

        System.out.print(sb);
        br.close();
    }
}
