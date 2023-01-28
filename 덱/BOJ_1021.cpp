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
        auto idx = find(Q.begin(), Q.end(), num);
        int idxNum;
        for (int i = 0; i < N; i++)
        {
            if (*idx == num)
            {
                idxNum = i;
            }
        }
        while (1)
        {
            if (idxNum == 0)
            {
                Q.pop_front();
                break;
            }
            else
            {

                if (Q.size() - idxNum > idxNum)
                {
                    Q.push_back(Q.front());
                    Q.pop_front();
                    n++;
                }
                else
                {
                    Q.push_front(Q.end());
                    Q.pop_back();
                    n++;
                }
            }
        }
    }
    cout << '\n';
}
