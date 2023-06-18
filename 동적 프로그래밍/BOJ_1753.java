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

public class BOJ_1753 {
    static int V, E; // 정점의 갯수, 간선의 갯수
    static int k; // 시작 정점의 번호(1<=k<=v)
    static int u, v, w; // 정점 u, 정점 v, 가중치 w(1<=u,v<=10)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int dist[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && nodeValue > dist[j]) {
                    nodeIdx = j;
                    nodeValue = dist[j];
                }
            }

            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node node = graph.get(nodeIdx).get(j);

                if (dist[node.idx] > dist[nodeIdx] + node.cost) {
                    dist[node.idx] = dist[nodeIdx] + node.cost;
                }
            }

        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");

            }
        }
        System.out.println(sb);
    }
}
