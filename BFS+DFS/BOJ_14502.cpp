#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
int N, M;
int graph[10][10];
int tmp[10][10];
int maxSafetyNum;
bool visited[10][10];
void copy(int tmp[10][10], int a[10][10])
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            tmp[i][j] = a[i][j];
        }
    }
}
void bfs()
{
    queue<pair<int, int>> q;
    int after[10][10];
    copy(after, tmp);

    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (after[i][j] == 2)
            {
                q.push({i, j});
            }
        }
    }
    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (after[nx][ny] != 0)
                continue;
            after[nx][ny] = 2;
            q.push({nx, ny});
        }
    }
    int num = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (tmp[i][j] == 0)
            {
                num++;
            }
        }
    }
    maxSafetyNum = max(maxSafetyNum, num);
}
void wall(int k)
{
    if (k == 3)
    {
        bfs();
        return;
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (tmp[i][j] == 0)
            {
                tmp[i][j] = 1;
                wall(k + 1);
                tmp[i][j] = 0;
            }
        }
    }
}

void dfs()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (graph[i][j] == 0)
            {
                for (int i = 0; i < N; i++)
                    fill(visited[N], visited[N] + M, false);
                copy(tmp, graph);
                tmp[i][j] = 1;
                wall(1);
                tmp[i][j] = 0;
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
    dfs();
    cout << maxSafetyNum;
}