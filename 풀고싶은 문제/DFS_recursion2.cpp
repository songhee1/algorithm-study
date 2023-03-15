#include <bits/stdc++.h>
using namespace std;
int N, M;

void bfs(vector<int> graph[], int node, bool visited[])
{
    if (visited[node] == true)
        return;

    visited[node] = true;
    cout << node << ' ';

    for (int i = 0; i < graph[node].size(); i++)
    {
        int x = graph[node][i];
        bfs(graph, x, visited);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    // 정점의 갯수, 간선의 갯수를 의미

    vector<int> graph[N + 1];
    

    bool visited[N + 1];
    fill(visited, visited + N + 1, false);

    int start = 0;
    for (int i = 0; i < M; i++)
    {
        int v, u;
        cin >> v >> u;
        if (i == 0)
            start = v;
        graph[v].push_back(u);
        graph[u].push_back(v);
    }

    bfs(graph, start, visited);
}