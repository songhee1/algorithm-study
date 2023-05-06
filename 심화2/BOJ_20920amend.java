package 심화2;

import java.io.*;
import java.util.*;

public class BOJ_20920amend {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;

    public static void main(String[] args) throws Exception {
        
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
    
        for(int i=0;i<n;i++){
            String s=br.readLine();
            if(s.length()>=m){
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2)->{
           int r1 = map.get(o1);
           int r2 = map.get(o2);
           
           if(r1==r2){
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            return o2.length()-o1.length();
           }
           return r2-r1;
        });

        for(String s : list){
            sb.append(s).append("\n");
        }

        System.out.print(sb);
        br.close();
        
    }
}
