#include <bits/stdc++.h>
using namespace std;
queue<pair<int, int>> q;
queue<pair<int, int>> q2;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
// 방 구조와 위치
string board[1002];
int R, C;
// 방문여부
bool vis[1002][1002];
// 시간세기
int dist1[1002][1002];
int dist2[1002][1002];

int main()
{
    cin >> R >> C;
    for (int i = 0; i < R; i++)
    {
        fill(dist1[i], dist1[i] + 1002, -1);
        fill(dist2[i], dist2[i] + 1002, -1);
    }

    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 'J')
            {
                vis[i][j] = 1;
                dist2[i][j] = 0;
                q2.push({i, j});
            }
            else if (board[i][j] == 'F')
            {
                vis[i][j] = 1;
                dist1[i][j] = 0;
                q.push({i, j});
            }
        }
    }

    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();
        // cout << "test: " << cur.first << ", " << cur.second << "\n";
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= C || ny < 0 || ny >= R)
                continue;
            if (board[nx][ny] == '#' || dist1[nx][ny] >= 0)
                continue;
            dist1[nx][ny] = dist1[cur.first][cur.second] + 1;
            q.push({nx, ny});
        }
    }
    while (!q2.empty())
    {
        pair<int, int> cur = q2.front();
        q2.pop();
        // cout << "test: " << cur.first << ", " << cur.second << "\n";
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= C || ny < 0 || ny >= R)
            {
                cout << dist2[cur.first][cur.second] + 1;
                return 0;
            }
            if (board[nx][ny] == '#' || dist2[nx][ny] != -1 || dist2[nx][ny] >= dist1[nx][ny])
                continue;
            dist2[nx][ny] = dist2[cur.first][cur.second] + 1;
            q2.push({nx, ny});
        }
    }
    cout << "IMPOSSIBLE";
}