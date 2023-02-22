#include <bits/stdc++.h>
using namespace std;
int T;
int num;
int sum;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        sum=0;
        for (int i = 0; i < 10; i++)
        {
            cin >> num;
            if (num % 2 != 0)
            {
                sum += num;
            }
        }
        cout << "#" << i << " " << sum << "\n";
    }
    return 0;
}