package 집합과맵;
import java.io.*;
import java.util.*;
public class BOJ_1269 {
    static int n,m;
    static int count1;

    /*
     * a세트, b세트 둘 중 포함되는게 있다면 1씩 증가
     * 시간: 768ms
     */
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        Set<Integer>aset=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) aset.add(Integer.parseInt(st.nextToken()));

        Set<Integer>bset=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) bset.add(Integer.parseInt(st.nextToken()));

        for(int num:bset){
            if(!aset.contains(num)) count1++;
        }

        for(int num:aset){
            if(!bset.contains(num)) count1++;
        }

        sb.append(count1);
        System.out.print(sb);
        br.close();
    }
}
