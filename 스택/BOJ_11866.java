package 스택;
import java.io.*;
import java.util.*;

public class BOJ_11866 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n,k;

    static int arr[];
    static Vector <Integer> v = new Vector<>();
    
    static int frontpointer, rearpointer;
    //7 1
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr=new int [500001];

        for(int i=1;i<=n;i++){
           arr[i-1]=i;
        }

        rearpointer=n;

        sb.append("<");

        //1 2 3 4 5 6 7
        while(v.size() != n){
            for(int i=1;i<=k-1;i++){
                arr[rearpointer]=arr[frontpointer];
                frontpointer++;
                rearpointer++;
            }
            v.add(arr[frontpointer]);
            frontpointer++;
        }

        for(int i=0;i<v.size();i++){
            if(i==v.size()-1){
                sb.append(v.get(i));
            }else sb.append(v.get(i)).append(", ");
        }

        sb.append(">");

        System.out.print(sb);
        br.close();

    }
}
