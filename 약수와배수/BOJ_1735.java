package 약수와배수;
import java.io.*;
import java.util.*;
public class BOJ_1735 {
    static int aup,adown;
    static int bup, bdown;
    static int down,up;
    /*
     * 유클리드 호제법 이용
     * 1.분모 간 최대공배수 구하고
     * 2.분모마다 곱한 값을 각 분자에 곱해주어 분자끼리 더한다
     * 3.최종 구해진 분모,분자에 대해 최대공약수를 구해 분자,분모에 나누어 주어 몫을 출력
     * 
     * 시간 : 124ms
     */
    public static void main(String [] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        aup=Integer.parseInt(st.nextToken());
        adown=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        bup=Integer.parseInt(st.nextToken());
        bdown=Integer.parseInt(st.nextToken());

        down=(adown*bdown)/gcb(adown, bdown);
        aup*=(down/adown);
        bup*=(down/bdown);

        up=aup+bup;

        int r=gcb(up,down);
        up/=r;
        down/=r;
        
        sb.append(up).append(' ').append(down);
        System.out.print(sb);
        br.close();
    }
    static int gcb(int a, int b){
        if(b==0) return a;
        return gcb(b,a%b);
    }
}
