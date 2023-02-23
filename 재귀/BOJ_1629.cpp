#include <bits/stdc++.h>
using namespace std;
long long A, B, C;
long long result = 1;

long long gop(int A, int B, int C)
{
    while (B--)
        result = result * A % C;
    return result;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> A >> B >> C;
    cout << gop(A, B, C);
    return 0;
}