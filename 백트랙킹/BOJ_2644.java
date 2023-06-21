package 백트랙킹;
import java.io.*;
import java.util.*;
public class BOJ_2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static int n; //전체 사람수
    static int arrayA, arrayB; //관계 촌수 계산해야할 번호 
    static int m; //관계 수
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean visit[];
    static List<Integer> list = new ArrayList<>();
    static int count = -1;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arrayA = Integer.parseInt(st.nextToken());
        arrayB = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        visit = new boolean[n+1];


        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        while(m -- >0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visit[arrayA] = true;
        dfs(arrayA, arrayB, count);
        if(count == -1){
            System.out.println(count);
        }else{
            System.out.println(count+1);
        }

    }
    static void dfs(int start, int end, int nums){
        if(start == end){
            count = nums;
        }

        for(int i=0;i<graph[start].size();i++){
            int a = graph[start].get(i);
            if(visit[a] == false){
                visit[a]  = true;
                dfs(a, end, nums+1);
            }
        }

    }  
}
