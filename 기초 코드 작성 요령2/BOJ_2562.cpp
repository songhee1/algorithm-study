#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N[9];
    for (int i = 0; i < 9; i++)
    {
        cin >> N[i];
    }
    int maxNum = N[0];
    for (int i = 0; i < 9; i++)
    {
        if (maxNum < N[i])
            maxNum = N[i];
    }
    for (int i = 0; i < 9; i++)
    {
        if (maxNum == N[i])
        {
            cout << maxNum << '\n'
                 << i + 1;
            break;
        }
    }
}