package 집합과맵;
import java.io.*;
import java.util.*;
public class BOJ_1620 {
    static int n,m;

    public static void main(String[] args)throws Exception{
        Map<String,Integer> mappedByName=new HashMap<>();
        Map<Integer,String> mappedByNumber=new HashMap<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            String s=br.readLine();
            mappedByName.put(s,i+1);
            mappedByNumber.put(i+1, s);
        }
        for(int j=0;j<m;j++){
            String s=br.readLine();
            sb.append(Character.isDigit(s.charAt(0)));
            if(mappedByName.containsKey(s)) sb.append(mappedByName.get(s)).append("\n");
            else sb.append(mappedByNumber.get(Integer.parseInt(s))).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
