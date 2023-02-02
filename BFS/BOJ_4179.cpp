#include <bits/stdc++.h>
using namespace std;
queue<pair<int, int>> q;
queue<pair<int, int>> q2;
int R, C, fire_go_minute, jihun_go_minute;
int fire_final_minute = 100000, jihun_final_minute = 100000;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
char miro[1002][1002];
bool fire_vis[1002][1002];
bool jihun_vis[1002][1002];
int jihun_escape_time[1002][1002];
int fire_escape_time[1002][1002];
int main()
{
    cin >> R >> C;
    for (int i = 0; i < C; i++)
    {
        for (int j = 0; j < R; j++)
        {
            char cha;
            cin >> cha;
            miro[i][j] = cha;
        }
    }
    for (int i = 0; i < C; i++)
    {
        for (int j = 0; j < R; j++)
        {
            if (miro[i][j] == 'J')
            {
                jihun_vis[i][j] = 1;
                q.push({i, j});
                jihun_escape_time[0][0] = 0;
            }
            else if (miro[i][j] == 'F')
            {
                fire_vis[i][j] = 1;
                q2.push({i, j});
                fire_escape_time[0][0] = 0;
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
            if (nx < 0 || nx >= C || ny < 0 || ny >= R)
                continue;
            if (miro[nx][ny] == '#' || miro[nx][ny] == 'F' || jihun_vis[nx][ny] == 1)
                continue;
            jihun_escape_time[nx][ny] = jihun_escape_time[cur.first][cur.second] + 1;
            jihun_vis[nx][ny] = 1;
            q.push({nx, ny});
            jihun_go_minute = max(jihun_go_minute, jihun_escape_time[nx][ny]);
            if (nx == C - 1 || ny == R - 1)
            {
                jihun_final_minute = min(jihun_go_minute, jihun_final_minute);
            }
        }
    }

    while (!q2.empty())
    {
        pair<int, int> cur = q2.front();
        q2.pop();
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= C || ny < 0 || ny >= R)
                continue;
            if (miro[nx][ny] == '#' || miro[nx][ny] == 'J' || fire_vis[nx][ny] == 1)
                continue;
            fire_escape_time[nx][ny] = fire_escape_time[cur.first][cur.second] + 1;
            fire_go_minute = max(fire_go_minute, fire_escape_time[nx][ny]);
            fire_vis[nx][ny] = 1;
            q2.push({nx, ny});
        }
    }

    if (jihun_final_minute <= fire_final_minute)
    {
        cout << jihun_final_minute + 1;
    }
    else
    {
        cout << "IMPOSSIBLE ";
    }
}