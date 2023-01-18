#include <iostream>
using namespace std;
int a[10000000] = {};
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    int x, numSang = 0;
    cin >> n;
    int b[n];
    fill(b, b + n, 0);
    for (int i = 0; i < n; i++)
    {
        cin >> b[i];
    }
    cin >> x;

    for (int i = 0; i < n; i++)
    {
        if (x >= b[i])
        {
            if (a[x - b[i]] == 1)
            {
                numSang++;
                a[b[i]] = 1;
            }
            else
                a[b[i]] = 1;
        }
    }
    cout << numSang;
}
