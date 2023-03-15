#include <bits/stdc++.h>
using namespace std;
bool visit[10];
vector<int> graph[10];
void bfs(int k)
{
    if (visit[k] == true)
        return;
    visit[k] = true;
    cout << k << ' ';
    for (int i = 0; i < graph[k].size(); i++)
    {
        int x = graph[k][i];
        bfs(x);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    graph[1].push_back(2);
    graph[2].push_back(1);

    graph[2].push_back(3);
    graph[3].push_back(2);

    graph[2].push_back(4);
    graph[4].push_back(2);

    graph[4].push_back(8);
    graph[8].push_back(4);

    graph[2].push_back(5);
    graph[5].push_back(2);

    graph[5].push_back(9);
    graph[9].push_back(5);

    graph[3].push_back(6);
    graph[6].push_back(3);

    graph[3].push_back(7);
    graph[7].push_back(3);

    bfs(1);
}