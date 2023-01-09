#include <iostream>
int main()
{
    using namespace std;
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, x, a[10000];
    cin >> n >> x;
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int i = 0; i < n; i++)
    {
        if (x > a[i])
            cout << a[i] << " ";
    }
}