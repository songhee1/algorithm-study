package 백트랙킹;
import java.io.*;
import java.util.*;
public class BOJ_2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static int n; //전체 사람수
    static int arrayA, arrayB; //관계 촌수 계산해야할 번호 
    static int m; //관계 수
    static Queue<Integer> queue = new LinkedList<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean visit[];
    static boolean flag;
    static int arr[];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arrayA = Integer.parseInt(st.nextToken());
        arrayB = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];


        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        while(m -- >0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            graph[a].add(b);
            if(flag == false){
                queue.add(a);
                arr[a] = 0;
                flag=true;
            }
            list.add(a);
            graph[b].add(a);
        }

        bfs(0);
        i

        for(int i=1;i<=m;i++){
            if(visit[i] == false){
                for(int num : list){
                    if(num == i){
                        queue.add(i);
                        bfs(0);
                        arr[i] = 0;
                    }
                }
            }
        }
    }
    static void bfs(int count){
        while(!queue.isEmpty()){
            int a = queue.poll();
            
            for(int i=0;i<graph[a].size();i++){
                if(visit[i] == false){
                    visit[i] = true;
                    arr[i] = ++count;
                }
            }
        }
    }
}
