#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 1; j <= i; j++)
            cout << ' ';
        for (int j = 1; j < N - i; j++)
            cout << '*';
        cout << '*';
        for (int j = 1; j < N - i; j++)
            cout << '*';
        for (int j = 1; j <= i; j++)
            cout << ' ';
        cout << '\n';
    }
}