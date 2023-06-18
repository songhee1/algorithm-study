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

public class BOJ_1916pq {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, start, end;
    static int dist[];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //최소비용을 저장할 배열 초기화
        dist = new int[n + 1]; // 최소비용 저장

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        /*
         * 주의점 1. 다익스트라 알고리즘의 최소비용을 기준으로 추출한다.
         * 최대비용을 기준으로 하는 경우 최악의 경우 지수시간 만큼 연산을 해야한다.
         *  
         */
        queue.offer(new Node(start, 0));
        //시작노드에서 시작노드로 가는 비용이 가장 짧은 비용이 되므로
        //우선순위큐에 넣어준다.

        while (!queue.isEmpty()) {
            Node nxtNode = queue.poll();
            //꺼낸 노드 = 현재 가장 최소 비용을 갖는 노드

            if (dist[nxtNode.idx] < nxtNode.cost)
                continue;
            //해당 노드의 비용이 현재 dist배열에 기록된 비용보다 크다면,
            //고려할 필요가 없으므로 스킵


            //선택 노드의 주변 노드들을 최소비용으로 갱신시킨다.
            for (int i = 0; i < graph.get(nxtNode.idx).size(); i++) {
                Node node = graph.get(nxtNode.idx).get(i);
                if (dist[node.idx] > dist[nxtNode.idx] + node.cost) {
                    dist[node.idx] = dist[nxtNode.idx] + node.cost;
                    queue.offer(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        System.out.println(dist[end]);

    }
}
