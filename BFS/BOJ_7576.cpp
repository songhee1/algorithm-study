#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int box[1002][1002];
int days[1002][1002];
bool vis[1002][1002];
queue<pair<int, int>> q;
queue<pair<int, int>> q2;
int m, n, day;

int dont_go, go;
int result=-2;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int num = 0;
            cin >> num;
            box[i][j] = num;
            if (box[i][j] == -1)
            {
                dont_go++;
            }
            else if (num == 1)
            {
                go++;
                q.push({i, j});
                vis[i][j] = 1;
                days[0][0] = 0;
            }
        }
    }
    if (m * n == go + dont_go)
    {
        result = 0;
    }

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
            if (box[nx][ny] == -1 || vis[nx][ny] == 1 || box[nx][ny] == '1')
                continue;
            days[nx][ny] = days[cur.first][cur.second] + 1;
            vis[nx][ny] = 1;
            box[nx][ny] =1;
            q.push({nx, ny});
            day = max(day, days[nx][ny]);
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (box[i][j] == 0)
            {
                result = -1;
            }
        }
    }

    if (result == 0)
    {
        cout << 0;
    }
    else if (result == -1)
    {
        cout << -1;
    }
    else
    {
        cout << day;
    }
}