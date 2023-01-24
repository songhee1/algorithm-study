#include <stack>
#include <iostream>
using namespace std;

char outputArray[10000000];
char outputArray2[10000000];
int pos;
int pos2;
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
            fill(outputArray, outputArray + 10000000, 0);
        }

        S.pop();
        outputArray[pos] = '-';
        pos++;
    }

    int nums = 0;
    for (auto i : outputArray)
    {

        if (i != 0)
        {
            outputArray2[pos2] = i;
            pos2++;
            nums++;
        }
    }
    if (nums == 0)
    {
        cout << "NO";
    }
    else
    {
        for (auto i : outputArray2)
            cout << i << '\n';
    }
}