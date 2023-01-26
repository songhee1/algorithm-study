#include <stack>
#include <iostream>
using namespace std;

char outputArray[10000000];
int pos;
char yn = 'y';
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    stack<int> S;
    int maxNum = 0;
    for (int i = 1; i <= n; i++)
    {
        int num;
        cin >> num;
        if (S.empty())
        {
            for (int j = i; j <= num; j++)
            {
                S.push(j);
                outputArray[pos] = '+';
                pos++;
                maxNum = max(maxNum, j);
            }
        }
        else if (S.top() < num)
        {
            for (int j = maxNum + 1; j <= num; j++)
            {
                S.push(j);
                outputArray[pos] = '+';
                pos++;
                maxNum = max(maxNum, j);
            }
        }
        else if (S.top() > num)
        {
            yn = 'n';
        }

        S.pop();
        outputArray[pos] = '-';
        pos++;
    }
    if (yn == 'y')
    {
        for (auto i : outputArray)
        {
            if (i != 0)
                cout << i << '\n';
        }
    }
    else
    {
        cout << "NO";
    }
}