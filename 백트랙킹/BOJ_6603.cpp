#include <bits/stdc++.h>
using namespace std;
int arr[15];
int n[15];
int k;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    while (1)
    {
        cin >> k;
        if(k==0) break;
        for (int i = 0; i < k; i++)
        {
            cin >> arr[i];
        }
        for (int i = 0; i < k; i++)
        {
            if (i < 6)
                n[i] = 0;
            else
                n[i] = 1;
        }
        do
        {
            for (int i = 0; i < k; i++)
            {
                if (n[i] == 0)
                {
                    cout << arr[i] << ' ';
                }
            }
            cout << "\n";
        } while (next_permutation(n, n + k));
    }
}