#include <bits/stdc++.h>
int dist[105][105][105];
int board[105][105][105];
int M, N, H;
using namespace std;
int maxday;
queue<tuple<int, int, int>> q;
int main()
{
    cin >> M >> N >> H;
    int dx[] = {1, 0, -1, 0, 0, 0};
    int dy[] = {0, 1, 0, -1, 0, 0};
    int dz[] = {0, 0, 0, 0, 1, -1};
    for (int h = 0; h < H; h++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                int tmp = 0;
                cin >> tmp;
                board[i][j][h] = tmp;
                if (board[i][j][h] == 1)
                {
                    q.push({i, j, h});
                }
                if(board[i][j][h]==0) dist[i][j][h] = -1;
            }
        }
    }

    while (!q.empty())
    {
        auto cur = q.front();
        q.pop();
        int i, j, k;
        tie(i, j, k) = cur;
        for (int dir = 0; dir < 6; dir++)
        {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            int nz = k + dz[dir];
            if (nx < 0 || nx > N || ny < 0 || ny > M || nz < 0 || nz > H)
                continue;
            if (dist[nx][ny][nz] >= 0)
                continue;
            dist[nx][ny][nz] = dist[i][j][k] + 1;
            q.push({nx, ny, nz});
            maxday = max(maxday, dist[nx][ny][nz]); 
        }
    }

    for (int h = 0; h < H; h++)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if(dist[i][j][h]==-1){
                    cout<<-1;
                    return 0;
                }
            }
        }
    }

    cout << maxday;
}