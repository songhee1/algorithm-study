#include <bits/stdc++.h>
int subin, sister;
int dist[100005];
using namespace std;
queue<int> q;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> subin >> sister;
    q.push(subin);
    dist[subin] = 0;
    fill(dist, dist + 100005, -1);

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();
        for (int nxt : {cur - 1, cur + 1, cur * 2})
        {

            if (nxt < 0 || dist[nxt] != -1 || nxt > 100000)
                continue;
            q.push(nxt);
            dist[nxt] = dist[cur] + 1;
            if (nxt == sister)
            {
                cout << dist[nxt];
                return 0;
            }
        }
    }
}