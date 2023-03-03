#include <bits/stdc++.h>
int T, N;
int dist[13][13];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        queue<pair<int, int>> q;
        for (int j = 0; j < 13; j++)
        {
            fill(dist[j], dist[j] + 13, 0);
        }
        cout << "#" << i << "\n";
        cin >> N;
        dist[0][0] = 1;
        q.push({0, 0});
        while (1)
        {
            pair<int, int> cur = q.front();
            q.pop();
            if (dist[cur.first][cur.second] == N * N)
                break;
            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (dist[nx][ny] > 0)
                    continue;
                if(dir==0){
                    int pnx=cur.first+dx[3];
                    int pny=cur.second+dy[3];
                    if(pnx>=0 && pnx<N&&pny>=0&&pny<N){
                        if(dist[pnx][pny]==0){
                            dir=2;
                            continue;
                        }
                    } 
                }
                // cout << cur.first << ' ' << cur.second << ", " << nx << ' ' << ny;
                // cout<<"\n";
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                q.push({nx, ny});
                break;
            }
        }
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                cout << dist[j][k] << ' ';
            }
            cout << "\n";
        }
        cout << "\n";
    }
}