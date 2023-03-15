#include <bits/stdc++.h>
using namespace std;
int N, M;
int arr[10][10];
bool vis[10][10];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
stack<pair<int, int>> s;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] != 0 || arr[i][j] != 6)
            {
                s.push({i, j});
            }
        }
    }
    while (!s.empty())
    {
        for (int dir = 0; dir < 4; dir++)
        {
            while (!s.empty())
            {
                pair<int, int> cur = s.top();
                s.pop();
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (arr[nx][ny] == 6)
                    continue;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                s.push({nx, ny});
                arr[nx][ny] = '#';
            }
        }
    }

    for(int i=0;i<N;i++){
        for(int j=0;i<M;j++){
            cout<<arr[i][j]<<' ';
        }
        cout<<"\n";
    }
}