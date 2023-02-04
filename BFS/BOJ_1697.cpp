#include <bits/stdc++.h>
int subin, sister;
bool vis[100005];
int dx[] = {1, -1, 2};
int nx;
int num;
using namespace std;
queue<pair<int, int>> q;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> subin >> sister;
    q.push({num, subin});
    vis[subin] = true;
    cout << q.front().second << ": is entered\n";

    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        q.pop();
        cout << cur.first << ", " << cur.second << " : visited, lastingTime : " << num << "\n";
        for (int dir = 0; dir < 3; dir++)
        {
            if (dir != 2)
            {
                nx = cur.second + dx[dir];
            }
            else
                nx = cur.second * dx[dir];
            if (nx < 0 || vis[nx] == true || nx > 100005)
                continue;
            if (nx == sister)
            {
                cout << num;
                return 0;
            }
            num = cur.first + 1;

            cout << nx << " : added\n";
            q.push({num, nx});
            vis[nx] = true;
        }
    }
}