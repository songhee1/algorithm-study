#include <iostream>
#include <stack>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    stack<int> S1, S2;
    for (int i = 1; i < N; i++)
    {
        int num;
        cin >> num;
        if (S1.empty())
        {
            S1.push(num);
            cout << 0 << ' ';
        }
        else
        {
            
            if (S1.top() > num)
            {
                cout << N - 1 << ' ';
                while (S2.size())
                {
                    S1.push(S2.top());
                    S2.pop();
                }
            }
            else
            {
                if (S1.size() != 1)
                {
                    S2.push(S1.top());
                    S1.pop();
                }
                else
                {
                    S1.push(num);
                    cout << 0 << ' ';
                }
            }
        }
    }
}