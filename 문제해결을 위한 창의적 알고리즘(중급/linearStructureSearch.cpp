#include <bits/stdc++.h>
int nArr[10005];
int mArr[10005];
int N, M;
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    int M = 0;
    for (int i = 0; i < N; i++)
        cin >> nArr[i];
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> mArr[i];
        int aws = 0;
        for (int j = 0; j < N; j++)
        {
            if (mArr[i] == nArr[j])
            {
                aws = 1;
                break;
            }
        }
        cout << aws<<"\n";

    }
}