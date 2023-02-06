#include <iostream>
#include <queue>
using namespace std;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int N;
string board[102];
bool vis[105][105];
int n = 2;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> board[i];
    }

    for (int idx = 2; idx > 0; idx--)
    {
        for(int i=0;i<105;i++)  fill(vis[i], vis[i] + 105, false);
        queue<pair<int, int>> q;
        int num = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (vis[i][j] == false)
                {
                    vis[i][j] = true;
                    q.push({i, j});
                    num++;
                    while (!q.empty())
                    {
                        pair<int, int> cur = q.front();
                        q.pop();

                        for (int dir = 0; dir < 4; dir++)
                        {
                            int nx = cur.first + dx[dir];
                            int ny = cur.second + dy[dir];
                            if (nx < 0 || nx > 100 || ny < 0 || ny > 100)
                                continue;
                            if (idx == 2)
                            {
                                if (vis[nx][ny] == true || board[nx][ny] != board[i][j])
                                    continue;
                            }
                            else if (idx == 1)
                            {
                                if (((board[i][j] == 'R' || board[i][j] == 'G') && board[nx][ny] == 'B') || vis[nx][ny] == true)
                                    continue;
                                if ((board[i][j] == 'B' && board[nx][ny] != 'B') || vis[nx][ny] == true)
                                    continue;
                            }
                            vis[nx][ny] = true;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        cout << num << ' ';
    }
}