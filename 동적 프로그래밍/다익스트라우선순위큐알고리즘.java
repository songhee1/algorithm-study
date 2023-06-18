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

public class 다익스트라우선순위큐알고리즘 {
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

        visitied = new boolean[V + 1];
        dist = new int[V + 1];

        // 1. 그래프의 리스트로 인덱스마다 리스트를 동적으로 구현해주는 리스트 추가
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
        }
        // [[],[],[],[],[]];

        // 2.최소 거리 정보를 담을 배열을 최댓값으로 초기화
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            // 현재 꺼낸 노드= 현재 최소 비용을 갖는 노드
            // 즉, 해당 노드 비용이 현재 dist배열에 기록된 노드의 비용보다 크다면 패스

            if (dist[curNode.idx] < curNode.cost)
                continue;

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);

                if (dist[nxtNode.idx] > dist[curNode.idx] + nxtNode.cost) {
                    dist[nxtNode.idx] = dist[curNode.idx] + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

    }
}
