#include <bits/stdc++.h>
using namespace std;
#define X first;
#define Y second;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    int board[n][m];
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    queue<pair<int, int>> Q;
    queue<pair<int, int>> Q2;
    int vis[n][m];
    int area = n * m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int num;
            cin >> num;
            board[i][j] = num;
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (board[i][j] == 1)
            {
                Q.push({i, j});
                vis[i][j] = 1;
            }
        }
    }
    int num = 0;
    int Qarea = 0;
    while (!Q.empty())
    {
        pair<int, int> cur = Q.front();
        Q.pop();
        num++;

        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (vis[nx][ny] == 1 || board[nx][ny] == 0)
                continue;
            if (board[nx][ny] == 1)
                Q2.push({nx, ny});
        }
        int newArea = 0;
        while (!Q2.empty())
        {
            pair<int, int> cur2 = Q2.front();
            Q2.pop();
            newArea++;

            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (vis[nx][ny] == 1 || board[nx][ny] == 0)
                    continue;
                if (board[nx][ny] == 1)
                    Q2.push({nx, ny});
            }
        }
        Qarea = max(Qarea, newArea);
    }
    cout << num << '\n';
    cout << Qarea << "\n";
}