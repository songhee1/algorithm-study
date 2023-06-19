
import java.io.*;
import java.util.*;

public class BOJ_24479 {
    static int n,m, v;
    //n은 정점수, m은 간선수, v는 시작정점
    
    static StringTokenizer st;
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static int count;
    static int checked[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
       
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        checked = new int[n+1];
        list = new ArrayList[n+1];
        
        visited = new boolean [n+1];
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i=0;i<n+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0;i<=n;i++){
            Collections.sort(list[i]);
        }

        count = 1;
        dfs(v);

        for(int i=1;i<=n;i++){
            System.out.println(checked[i]);
        }
    }
    static void dfs(int node){
        visited[node] = true;
        checked[node] = count;
        
        for(int i=0;i<list[node].size();i++){
            int nextNode = list[node].get(i);
            if (visited[nextNode] == false){
                count++;
                dfs(nextNode);
            }
        }
    }
}
