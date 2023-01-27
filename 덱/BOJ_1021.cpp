#include <iostream>
#include <deque>
using namespace std;
int secondNum, thirdNum;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, M;
    cin >> N >> M;
    deque<int> Q;
    deque<int>::iterator it;
    for (int i = 1; i <= N; i++)
        Q.push_back(i);
    while (M--)
    {
        it = Q.begin();
        auto it2 = Q.end();
        int num;
        cin >> num;
        if (it2 - 1 >= it + num - 1)
        {
            Q.erase(it + num - 1);
            for (auto i : Q)
                cout << i << ' ';
            if ((it + num - 1) - it > (it2 - 1) - (it + num - 1))
            {
                int b = (it2 - 1) - (it + num - 1);

                while (b--)
                    thirdNum++;
                cout << "thirdNum값은 " << thirdNum;
            }
            else
            {
                int a = (it + num - 1) - it;
                while (a--)
                    secondNum++;

                cout << "secondNum값은 " << secondNum;
            }
        }
        cout << '\n';
    }
    cout << min(secondNum, thirdNum);
}
