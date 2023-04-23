package 집합과맵;
import java.io.*;
import java.util.*;
public class BOJ_14425 {
    static int n,m;
    static int count;
    /*
     * 해당 문자열들이 있는지 확인해야 하므로 중복된 값을 저장하지 않는 Set으로 저장한다.
     */
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        Set<String> s=new HashSet<>();
         
        for(int i=0;i<n;i++) {
            String ss=br.readLine();
            if(!s.contains(ss)) s.add(ss);
        }
        for(int i=0;i<m;i++){
            if(s.contains(br.readLine())) count++;
        }

        br.close();
        System.out.println(count);
    }

}
