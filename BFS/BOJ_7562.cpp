#include <bits/stdc++.h>

int T, L;
int x, y;
int go_x, go_y;
using namespace std;
int maxnum;

int dx[] = {2, 2, 1, 1, -1, -1, -2, -2};
int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
int dist[305][305];
queue<int> answer;
int main()
{
    cin >> T;

    while (T--)
    {
        queue<pair<int, int>> q;
        for (int i = 0; i < 305; i++)
        {
            fill(dist[i], dist[i] + 305, -1);
        }
        cin >> L >> x >> y >> go_x >> go_y;
        dist[x][y] = 0;
        q.push({x, y});
        while (!q.empty())
        {

            pair<int, int> cur = q.front();
            q.pop();
            for (int dir = 0; dir < 8; dir++)
            {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx > 300 || ny < 0 || ny > 300)
                    continue;
                
                dist[nx][ny] = dist[cur.first][cur.second] + 1;
                if (nx == go_x && ny == go_y)
                {

                q.push({nx, ny});
            }
        }
    }

    for(int i=0;i<3;i++){
        cout<<answer.front()<<"\n";
        answer.pop();
    }
}