#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    for (int i = N; i >= 1; i--)
    {
        for (int j = N; j > i; j--)
            cout << ' ';
        for (int k = 1; k <= (2 * i - 1); k++)
            cout << '*';
        cout << '\n';
    }
}
