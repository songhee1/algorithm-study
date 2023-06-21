#include <bits/stdc++.h>
using namespace std;
vector<int> graph[105];
int N, M;
bool visited[105];
int num;
void dfs(int node)
{
    if (visited[node] == 1)
        return;

    visited[node] = 1;
    if (node != 1)
        num++;
    for (int i = 0; i < graph[node].size(); i++)
    {
        dfs(graph[node][i]);
    }
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int n, m;
        cin >> n >> m;
        graph[n].push_back(m);
        graph[m].push_back(n);
    }
    dfs(1);

    cout << num;
}