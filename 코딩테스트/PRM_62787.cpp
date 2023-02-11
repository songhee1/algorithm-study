#include <bits/stdc++.h>
using namespace std;
string grid[1005];
int dist[1005][1005];
queue<pair<int, int>> q;
int dx[] = {1, 0, -1, 0, 1, -1, 1, -1};
int dy[] = {0, 1, 0, -1, -1, -1, 1, 1};
int grid_len, rowlen;
int sum;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> grid_len>>rowlen;
    for (int i = 0; i < grid_len; i++)
    {
        cin >> grid[i];
    }

    for (int i = 0; i < grid_len; i++)
    {
        fill(dist[i], dist[i] + rowlen, 0);
    }
    for (int i = 0; i < grid_len; i++)
    {
        for (int j = 0; j < rowlen; j++)
        {
            if (grid[i][j] == '#' && dist[i][j] == 0)
            {
                q.push({i, j});
                dist[i][j] = 1;
                while (!q.empty())
                {
                    cout<<"push"<<"\n";
                    pair<int, int> cur = q.front();
                    for (int dir = 0; dir < 8; dir++)
                    {
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if (nx < 0 || nx >= grid_len || ny < 0 || ny <= rowlen)
                            continue;
                        if (dist[nx][ny] > 0 || grid[nx][ny] == '.')
                            continue;
                        dist[nx][ny] = dist[cur.first][cur.second] + 1;
                        q.push({nx, ny});
                        sum = max(sum, dist[nx][ny]);
                    }
                }
            }
        }
    }
    cout << sum;
}