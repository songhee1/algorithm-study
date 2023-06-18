import java.io.*;
import java.util.*;

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class BOJ_1916 {
    static int V, E; // 노드와 간선의 갯수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean visitied[];
    static int dist[];
    static int start;

    public static void main(String[] args) throws Exception {
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        start = Integer.parseInt(br.readLine());

        visitied = new boolean [V+1];
        dist = new int [V+1];
        
        //1. 그래프의 리스트로 인덱스마다 리스트를 동적으로 구현해주는 리스트 추가
        for(int i=0;i<V+1;i++){
            graph.add(new ArrayList());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
        }
        //[[],[],[],[],[]];

        //2.최소 거리 정보를 담을 배열을 최댓값으로 초기화
        for(int i=0;i<V+1;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        //출발 지점은 비용을 0으로 설정
        dist[start]=0;

        //3. 다익스트라 알고리즘 진행
        //모든 노드를 방문하면 종료하기 때문에, 노드의 개수만큼 반복

        for(int i=0;i<V;i++){
            //4-1. 현재 거리비용 중 최소 지점을 선택
            //해당 노드가 가진 현재 비용
            int nodeValue = Integer.MAX_VALUE;
            //해당 노드의 인덱스 번호
            int nodeIdx = 0;

            for(int j=1;j<V+1;j++){
                //해당 노드를 방문하지 않은 것 중, 현재 모든 거리 비용 중 최솟값 찾기
                if(!visitied[j] && dist[j] < nodeValue){
                    nodeValue = dist[j];
                    nodeIdx = j;
                    System.out.println(nodeIdx);
                }
            }

            //최종 선택된 노드를 방문처리
            visitied[nodeIdx] = true;

            //4-2 해당 노드 기준으로 인접노드의 최소거리값 갱신
            for(int j=0;j<graph.get(nodeIdx).size();j++){
                //인접 노드 선택
                Node node = graph.get(nodeIdx).get(j);

                //인접 노드가 가진 최소 비용과 
                //현재 선택된 노드를 거쳐+현재 노드에서 인접노드로 가는 값 비교
                //더 작은 값으로 갱신한다.
                if(dist[node.idx]>dist[nodeIdx]+node.cost){
                    dist[node.idx] = dist[nodeIdx]+node.cost;
                }
            }
        }

        
        
    }
}
