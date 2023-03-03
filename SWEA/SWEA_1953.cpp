#include <bits/stdc++.h>

int dist[55][55];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int cnt;
int arr[55][55];
bool isexceed = false;
int finalcnt;
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T, N, M, R, C, L;
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        queue<pair<int, int>> q;
        for (int j = 0; j < 55; j++)
        {
            fill(dist[j], dist[j] + 55, 0);
        }
        isexceed=false;
        finalcnt=0;
        cout << "#" << i << ' ';
        cin >> N >> M >> R >> C >> L;
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < M; k++)
            {
                cin >> arr[j][k];
            }
        }
        dist[R][C] = 1;
        cnt = 1;
        q.push({R, C});
        while (!q.empty())
        {
            pair<int, int> cur = q.front();
            q.pop();

            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (dist[nx][ny] > 0 || arr[nx][ny] == 0)
                    continue;
                if ((arr[cur.first][cur.second] == 1 || arr[cur.first][cur.second] == 3 || arr[cur.first][cur.second] == 4 || arr[cur.first][cur.second] == 5) && dir == 0)
                {
                    if (arr[nx][ny] != 3 && arr[nx][ny] != 6 && arr[nx][ny] != 7 && arr[nx][ny] != 1)
                        continue;
                }
                else if ((arr[cur.first][cur.second] == 1 || arr[cur.first][cur.second] == 2 || arr[cur.first][cur.second] == 5 || arr[cur.first][cur.second] == 6) && dir == 1)
                {
                    if (arr[nx][ny] != 1 && arr[nx][ny] != 2 && arr[nx][ny] != 4 && arr[nx][ny] != 7)
                        continue;
                }
                else if ((arr[cur.first][cur.second] == 1 || arr[cur.first][cur.second] == 3 || arr[cur.first][cur.second] == 6 || arr[cur.first][cur.second] == 7) && dir == 2)
                {
                    if (arr[nx][ny] != 1 && arr[nx][ny] != 3 && arr[nx][ny] != 4 && arr[nx][ny] != 5)
                        continue;
                }
                else if ((arr[cur.first][cur.second] == 1 || arr[cur.first][cur.second] == 2 || arr[cur.first][cur.second] == 4 || arr[cur.first][cur.second] == 7) && dir == 3)
                {
                    if (arr[nx][ny] != 1 && arr[nx][ny] != 2 && arr[nx][ny] != 5 && arr[nx][ny] != 6)
                        continue;
                }else continue;
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                if(dist[nx][ny]>L) continue;
                q.push({nx, ny});
                cnt++;
            }
        }
        cout<<cnt<<"\n";
       
    }
}