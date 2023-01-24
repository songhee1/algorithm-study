#include <stack>
#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> S;
    int K;
    cin >> K;
    while (K--)
    {
        int num;
        cin >> num;
        if (num != 0)
            S.push(num);
        else if (num == 0)
        {
            S.pop();
        }
    }

    int sum = 0;
    for (int i = 0;; i++)
    {
        if (S.size() != 0)
        {
            sum += S.top();
            S.pop();
        }
        else
            break;
    }
    cout << sum;
}