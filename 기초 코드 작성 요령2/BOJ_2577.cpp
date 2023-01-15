#include <iostream>
#include <string.h>
#include <typeinfo>

using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int A, B, C;
    cin >> A >> B >> C;
    string s = to_string(A * B * C);
    for (int i = 0; i < 10; i++)
    {
        int sum = 0;
        for (int j = 0; j < s.length(); j++)
        {
            if (s[j] == i + 48)
                sum++;
        }
        cout << sum << '\n';
    }
}