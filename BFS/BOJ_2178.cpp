#include <bits/stdc++.h>
using namespace std;
queue<pair<int, int>> q;
bool vis[102][102];
int board[102][102];
#define X first;
#define Y second;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m, cans, num;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
        }
    }
    
    q.push({0,0});
    vis[0][0]=1;
    cans++;
    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (vis[nx][ny] == 1 || board[nx][ny] == 0)
                continue;

            vis[nx][ny] = 1;
            q.push({nx, ny});
            cans++;

            if (nx == n && ny == m)
            {
                cout << cans;
                return 0;
            }
        }
    }
}