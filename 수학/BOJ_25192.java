package 수학;
import java.io.*;
import java.util.*;
public class BOJ_25192 {
    static int n,count;
    static String ss;
    static boolean enter;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Set<String>s=new HashSet<>();
        
        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            ss=br.readLine();
            if(ss.equals("ENTER")) {
                enter=true;
                count+=s.size();
                s.clear();
            }
            else{
                if(enter) s.add(ss);
            }
        }
        count+=s.size();
        sb.append(count);

        System.out.print(sb);
        
    }
}
