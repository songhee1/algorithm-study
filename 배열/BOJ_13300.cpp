#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, k, s, y;
    int allStudentsNum[13] = {};
    cin >> N >> k;
    for (int i = 0; i < N; i++)
    {
        cin >> s >> y;
        if (s == 1)
            allStudentsNum[2 * y]++;
        else
            allStudentsNum[2 * y - 1]++;
    }

    int sumRoom = 0;
    for (int i = 0; i < 13; i++)
        sumRoom += (allStudentsNum[i] + (k - 1)) / k;
    cout << sumRoom;
}