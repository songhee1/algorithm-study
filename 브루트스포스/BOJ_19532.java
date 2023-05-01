package 브루트스포스;
import java.io.*;
import java.util.*;
public class BOJ_19532 {
    static int a,b,c,d,e,f;
    static int x, y;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        f=Integer.parseInt(st.nextToken());

        is_right();

        sb.append(x).append(' ').append(y);
        System.out.print(sb);
        br.close();
    }
    static void is_right(){
        for(int i=-999;i<=999;i++ ){
            for(int j=-999;j<=999;j++){
                if(a*i+b*j==c && d*i+e*j==f){
                    x=i;
                    y=j;
                    return;
                }
            }
        }
    }
}
