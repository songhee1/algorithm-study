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

public class 다익스트라알고리즘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m; // 도시의 갯수, 벗스의 갯수
    static int start, end; // 출발점, 도착점
    static boolean visitied[];
    static int dist[];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        visitied = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 도착지점 거리 0 설정
        dist[start] = 0;

        // 인접한 노드 중 방문하지 않았으면서 비용이 가장 작은 노드 찾기
        for (int i = 0; i < n; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 1; j <= n; j++) {
                if (visitied[j] == false && dist[j] < nodeValue) {
                    nodeIdx = j;
                    nodeValue = dist[j];
                }
            }

            visitied[nodeIdx] = true;

            // 찾은 노드를 기준으로 인접한 노드들 비용 갱신시키기
            for (int j = 0; j < list.get(nodeIdx).size(); j++) {
                Node node = list.get(nodeIdx).get(j);
                if (dist[node.idx] > dist[nodeIdx] + node.cost) {
                    dist[node.idx] = dist[nodeIdx] + node.cost;
                }
            }
        }

        System.out.println(dist[end]);

    }
}
