#include <bits/stdc++.h>
using namespace std;
int T, N;
int arr[15][15];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        cin >> N;
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                cin >> arr[j][k];
            }

        }
    }
} 