#include <bits/stdc++.h>
using namespace std;
int dist[102][102];
string board[102];
int vis[102][102];
int n, m;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
queue<pair<int, int>> q;
int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        cin >> board[i];

    dist[0][0] = 1;
    vis[0][0] = 1;
    for (int i = 0; i < n; i++)
        fill(dist[i], dist[i] + m, -1);
    q.push({0, 0});
    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (board[nx][ny] == '0' || dist[nx][ny] >= 0)
                continue;
            vis[nx][ny] = 1;
            q.push({nx, ny});
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << dist[i][j];
        }
    }
    cout << dist[n - 1][m - 1] + 1;
}