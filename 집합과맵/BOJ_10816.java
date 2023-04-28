package 집합과맵;
import java.io.*;
import java.util.*;
public class BOJ_10816 {
    static int n,m;
    static int s;
    public static void main(String []args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();

        n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            s=Integer.parseInt(st.nextToken());
            if(map.containsKey(s)) map.put(s,map.get(s)+1);
            else map.put(s,1);
        }

        m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            s=Integer.parseInt(st.nextToken());
            if(map.containsKey(s)) sb.append(map.get(s)).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
