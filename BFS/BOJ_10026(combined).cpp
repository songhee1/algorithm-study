#include <bits/stdc++.h>
using namespace std;
int N;
string board[105];
bool vis[105][105];
int num;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
queue<pair<int, int>> q;
void queueStack(int i, int j)
{
    vis[i][j] = true;
    q.push({i, j});
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
            if (vis[nx][ny] == true || board[nx][ny] != board[i][j])
                continue;
            vis[nx][ny] = true;
            q.push({nx, ny});
        }
    }
}

int area()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (vis[i][j] == false)
            {
                num++;
                queueStack(i, j);
            }
        }
    }
    return num;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> board[i];
    }
    int n_patient = area();

    for(int i=0;i<105;i++){
        fill(vis[i],vis[i]+105,false);
    }
    num=0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (board[i][j]=='G')
            {
                board[i][j]='R';
            }
        }
    }
    int patient=area();
    cout<<n_patient<<' '<<patient;

}