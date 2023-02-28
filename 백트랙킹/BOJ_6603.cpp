#include <bits/stdc++.h>
using namespace std;
int k, arr[15];
int answer[8];
int isused[15];
int n[15];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    while (1)
    {
        cin >> k;
        if (k == 0)
            break;
        for (int i = 0; i < k; i++)
        {
            cin >> arr[i];
            if (i > 5)
            {
                n[i] = 1;
            }
            else
            {
                n[i] = 0;
            }
        }

        do
        {
            for (int i = 0; i < 6; i++)
            {
                if (n[i] == 0)
                {
                    cout << arr[i] << ' ';
                }
            }
            cout << "\n";
        } while (next_permutation(n, n + k))
    }
}