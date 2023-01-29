#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;
int n;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, M;
    cin >> N >> M;
    deque<int> Q;
    for (int i = 0; i < N; i++)
        Q.push_back(i + 1);
    while (M--)
    {
        int num;
        cin >> num;
        int idxNum;
        for (int i = 0; i < N; i++)
        {
            if (Q[i] == num)
            {
                idxNum = i;
                break;
            }
        }

        if (Q.size() - idxNum > idxNum)
        {
            while (1)
            {
                if (Q.front() == num)
                {
                    Q.front();
                    break;
                }
                else
                {
                    Q.push_back(Q.front());
                    Q.pop_front();
                    n++;
                }
            }
        }
        else
        {
            while (1)
            {
                if (Q.front() == num)
                {
                    Q.front();
                    break;
                }
                else
                {
                    Q.push_front(Q.back());
                    Q.pop_back();
                    n++;
                }
            }
        }
    }
    cout << '\n';
}
