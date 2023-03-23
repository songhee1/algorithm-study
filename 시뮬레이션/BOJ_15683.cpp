#include <bits/stdc++.h>
using namespace std;
int N, M;
int graph[10][10];
int tmp[10][10];
bool vis[10][10];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
stack<pair<int, int>> s;

void copy(int graph[10][10], int tmp[10][10])
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            tmp[i][j] = graph[i][j];
        }
    }
}

void dfs(int i, int j)
{
    s.push({i, j});
    pair<int, int> cur = s.top();
    for (int dir = 0; dir < 4; dir++)
    {
        while (1)
        {
            if(s.empty()) break;
            pair<int, int> subCur = s.top();
            s.pop();
            int nx = subCur.first + dx[dir];
            int ny = subCur.second + dx[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (tmp[nx][ny] == 6)
                continue;
            if (tmp[nx][ny] > 0)
            {
                s.push({nx, ny});
            }
            else
            {
                s.push({nx, ny});
                tmp[nx][ny] = '#';
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> graph[i][j];
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (graph[i][j] != 6)
            {
                copy(graph, tmp);
                dfs(i, j);
            }
        }
    }
}