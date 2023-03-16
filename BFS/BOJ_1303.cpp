#include <bits/stdc++.h>
using namespace std;
int visited[105][105];
char graph[105][105];
int N, M;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int wpNum;
int bpNum;
queue<pair<int, int>> q;

int bfs(int i, int j)
{
    int num = 1;
    cout<<"print";
    char c = graph[i][j];
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
            if (graph[nx][ny] != c || visited[nx][ny] == 1)
                continue;
            num++;
            visited[nx][ny] = 1;
            q.push({nx, ny});
        }
    }
    return num * num;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
            cin >> graph[i][j];
    }
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j])
            {
                visited[i][j] = 1;
                q.push({i,j});
                if (graph[i][j] == 'W')
                    wpNum += bfs(i, j);
                else
                    bpNum += bfs(i, j);
            }
        }
    }
    cout << wpNum << ' ' << bpNum;
}