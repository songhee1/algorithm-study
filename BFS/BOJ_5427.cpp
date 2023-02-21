#include <bits/stdc++.h>

int test;
int w, h;
using namespace std;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int dist1[1005][1005];
int dist2[1005][1005];
string board[1005];
pair<int, int> current;
bool isescape;

int main()
{
    cin >> test;
    while (test--)
    {
        queue<pair<int, int>> q1;
        queue<pair<int, int>> q2;
        isescape=false;
        for (int i = 0; i < 1005; i++)
        {
            fill(dist1[i], dist1[i] + 1005, -1);
            fill(dist2[i], dist2[i] + 1005, -1);
        }
        cin >> w >> h;
        for (int i = 0; i < h; i++)
        {
            cin >> board[i];
        }
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (board[i][j] == '@')
                {
                    q1.push({i, j});
                    dist1[i][j] = 0;
                }
                if (board[i][j] == '*')
                {
                    q2.push({i, j});
                    dist2[i][j] = 0;
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
                if (nx < 0 || nx > h || ny < 0 || ny > w)
                    continue;
                if (board[nx][ny] == '#' || dist2[nx][ny] >= 0)
                    continue;
                dist2[nx][ny] = dist2[cur.first][cur.second] + 1;
                q2.push({nx, ny});
            }
        }
        while (!q1.empty())
        {

            pair<int, int> cur = q1.front();
            q1.pop();
            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx > h || ny < 0 || ny > w)
                {
                    current.first = cur.first;
                    current.second = cur.second;
                    isescape = true;
                }
                if (board[nx][ny] == '#' || (dist2[nx][ny] != -1 && dist1[cur.first][cur.second] + 1 > dist2[nx][ny]))
                    continue;
                dist1[nx][ny] = dist1[cur.first][cur.second] + 1;
                q1.push({nx, ny});
            }
        }
        if (isescape)
        {
            cout << dist1[current.first][current.second] << "\n";
        }
        else
        {
            cout << "IMPOSSIBLE\n";
        }
    }
}