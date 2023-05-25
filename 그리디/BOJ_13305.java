package 그리디;
import java.io.*;
import java.util.*;

public class BOJ_13305 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, cost;
    static int roads[];
    static int cities[];
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        cities = new int[n];
        roads = new int[n-1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            roads[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx =0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cities[i] = Integer.parseInt(st.nextToken());
            if(i!=0){
                if(cities[i-1]>cities[i] || i == n-1){
                    cost += cities[i-1] * (i-idx);
                    idx=i;
                }else if(cities[i-1] == cities[i]){
                    continue;
                }
            }
        }


        System.out.println(cost);
    }
}
