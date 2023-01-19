#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, v;
    cin >> N;
    int a[N] = {};
    for (int i = 0; i < N; i++)
        cin >> a[i];
    cin >> v;
    int numFind = 0;
    for (int i = 0; i < N; i++)
        if (v == a[i])
            numFind++;

    cout << numFind;
}