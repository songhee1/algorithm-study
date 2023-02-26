#include <bits/stdc++.h>
using namespace std;
int N, M;
int answer[15];
int isused[15];
void func(int k)
{
    if (k == M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << answer[i] << ' ';
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= N; i++)
    {
        if (!isused[i])
        {
            if (k != 0 && answer[k - 1] < i)
            {
                isused[i] = 1;
                answer[k] = i;
                func(k + 1);
                answer[k] = 0;
                isused[i] = 0;
            }
            else if (k == 0)
            {
                isused[i] = 1;
                answer[k] = i;
                func(k + 1);
                answer[k] = 0;
                isused[i] = 0;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    func(0);
}