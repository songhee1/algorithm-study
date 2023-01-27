#include <iostream>
#include <deque>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int> Q;
    int N;
    cin >> N;
    while (N--)
    {
        string command;
        cin >> command;
        if (command == "push_back")
        {
            int num;
            cin >> num;
            Q.push_back(num);
        }
        else if (command == "push_front")
        {
            int num;
            cin >> num;
            Q.push_front(num);
        }
        else if (command == "pop_front")
        {
            if (Q.empty())
                cout << -1 << '\n';
            else
            {

                cout << Q.front() << '\n';
                Q.pop_front();
            }
        }
        else if (command == "pop_back")
        {
            if (Q.empty())
                cout << -1 << '\n';
            else
            {

                cout << Q.back() << '\n';
                Q.pop_back();
            }
        }
        else if (command == "size")
        {
            cout << Q.size() << '\n';
        }
        else if (command == "empty")
        {
            if (Q.empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }
        else if (command == "front")
        {
            if (Q.empty())
                cout << -1 << '\n';
            else
                cout << Q.front() << '\n';
        }
         else if (command == "back")
        {
            if (Q.empty())
                cout << -1 << '\n';
            else
                cout << Q.back() << '\n';
        }
    }
}