#include <bits/stdc++.h>
using namespace std;
int T;
float result;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        result = 0;
        for (int i = 0; i < 10; i++)
        {
            int num = 0;
            cin >> num;
            result += num;
        }
        cout << "#" << i << " " << round(result / 10.0)<< "\n";
    }
}