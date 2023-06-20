package 백트랙킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static ArrayList<Integer>[] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean visit[];
    static int arr[];
    static int n;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visit = new boolean[n + 1];
        graph = new ArrayList[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        soltuion();
        System.out.println(sb);
    }

    static void soltuion(){
        queue.add(1);
        visit[1] = true;
        BFS();
        for(int i=2;i<=n;i++){
            sb.append(arr[i]).append("\n");
        }
    }
    static void DFS(int node){
        for(int y : graph[node]){
           if(visit[y] == true) continue;
           visit[y] = true;
           arr[y] = node;
           DFS(y);
        }
    }
    static void BFS(){
        while(!queue.isEmpty()){
            int a = queue.poll();

            for(int b : graph[a]){
                if(visit[b] == true) continue;
                visit[b] = true;
                arr[b] = a;
                queue.add(b);
            }
        }
    }
}
