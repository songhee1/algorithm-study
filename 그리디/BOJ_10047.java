package 그리디;
import java.io.*;
import java.util.*;

public class BOJ_10047 {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        int coinsNum=0;

        for(int i=list.size()-1;i>=0;i--){
            if(k>=list.get(i)){
                coinsNum += k/list.get(i);
                k = k%list.get(i);
            }
        }

        System.out.print(coinsNum);
    }
    
}
