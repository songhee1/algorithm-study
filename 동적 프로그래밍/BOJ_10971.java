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

public class BOJ_10971 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; // 도시의 수
    static int dist[];
    static StringTokenizer st;
    static int arr[][];
    static int minCost;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        dist = new int[n + 1];
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                graph.get(i).add(new Node(j, arr[i][j]));
            }
        }

        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            dist[i] = 0;

            for (int j = 0; j < n; j++) {
                int nodeValue = Integer.MAX_VALUE;
                int nodeIdx = i;
                for (int k = 1; k < n + 1; k++) {
                    if (!visited[k] && dist[k] < nodeValue) {
                        nodeValue = dist[k];
                        nodeIdx = k;
                    }
                }

                visited[nodeIdx] = true;

                for(int k=0;k<graph.get(nodeIdx).size();k++){
                    Node nxtNode = graph.get(nodeIdx).get(k);
                    
                    if(dist[nxtNode.idx]>dist[nodeIdx]+nxtNode.cost){
                        dist[nxtNode.idx]=dist[nodeIdx]+nxtNode.cost;
                    }
                }
            }

            minCost = Math.min(minCost, dist[i]);
        }

        System.out.println(minCost);
    }
}
