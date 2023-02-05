#include <bits/stdc++.h>
using namespace std;
int dy[] = {0, 1, 0, -1};
int dx[] = {1, 0, -1, 0};
int T, M, N, K;
int X, Y;
int num;
bool vis[50][50];
int board[50][50];
int a[2];
int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;

    for(int i=0;i<2;i++)
    {

        queue<pair<int, int>> q;
        for (int i = 0; i < 50; i++)
        {
            fill(board[i], board[i] + 50, 0);
            fill(vis[i], vis[i] + 50, 0);
        }

        cin >> M >> N >> K;
        for (int i = 0; i < K; i++)
        {
            cin >> X >> Y;
            board[Y][X] = 1;
        }
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (board[i][j] == 1 && vis[i][j] == false)
                {
                    q.push({i, j});
                    vis[i][j] = 1;
                    num++;
                    while (!q.empty())
                    {
                        pair<int, int> cur = q.front();
                        q.pop();
                        for (int dir = 0; dir < 4; dir++)
                        {
                            int nx = cur.first + dx[dir];
                            int ny = cur.second + dy[dir];
                            if (board[nx][ny] != 1 || vis[nx][ny])
                                continue;
                            if (nx < 0 || nx > N || ny < 0 || ny > M)
                                continue;
                            vis[nx][ny] = 1;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        a[i]=num;
    }
    for(int i:a){
        cout<<i<<
    }
}
