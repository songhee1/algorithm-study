#include <bits/stdc++.h>
using namespace std;
int N;
int tmp;
int a[1005];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
    }

    for (int i = 0; i < N - 1; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            if (a[i] > a[j])
            {
                tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
    }
    cout<<"\n";
    for (int i = 0; i < N; i++)
    {
        cout << a[i] << "\n";
    }
}