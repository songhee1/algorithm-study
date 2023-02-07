#include <bits/stdc++.h>
using namespace std;
int maxNum[3] = {0, 1, 1};
int board[10][10];
bool hasNeverChange = true;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {

            cin >> board[i][j];
            if (board[i][j] > maxNum[0])
            {
                maxNum[0] = board[i][j];
                maxNum[1] = i + 1;
                maxNum[2] = j + 1;
            }
        }
    }
    cout << maxNum[0] << "\n";
    cout << maxNum[1] << ' ' << maxNum[2];
}