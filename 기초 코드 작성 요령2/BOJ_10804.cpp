#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    int cards[20];
    for (int i = 1; i < 21; i++)
        cards[i] = i;
    int a, b;
    for (int i = 0; i < 10; i++)
    {
        cin >> a >> b;
        revese(begin(cards) + a, end(cards) + b)
    }

    for (int i = 1; i < 21; i++)
        cout << cards[i] << ' ';
}