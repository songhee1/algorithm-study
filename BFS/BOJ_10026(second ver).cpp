#include <bits/stdc++.h>
using namespace std;
int N;
string board[105];
bool vis[105][105];
char pill;
int num;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
queue<pair<int, int>> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> board[i];
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (vis[i][j] == false)
            {
                // cout<<"new pill position: "<<i<<", "<<j;
                pill = board[i][j];
                q.push({i, j});
                vis[i][j] = true;
                num++;
                while (!q.empty())
                {

                    pair<int, int> cur = q.front();
                    q.pop();
                    for (int dir = 0; dir < 4; dir++)
                    {
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if (nx < 0 || nx > N || ny < 0 || ny > N)
                            continue;
                        if (vis[nx][ny] == true )
                            continue;
                        if((pill=='R'|| pill=='G') && board[nx][ny]=='B') continue;
                        if(pill=='B' && board[nx][ny]!='B') continue;
                        vis[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
        }
    }
    cout << num;
}