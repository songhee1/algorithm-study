#include <iostream>
using namespace std;
#include <cstring>
#include <stack>

int arrayInt[100000];
int pos;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    // stack<int> S;
    // int N;
    // cin >> N;
    // while (N--)
    // {
    //     char command[10];
    //     cin >> command;
    //     if (strcmp(command, "push") == 0)
    //     {
    //         int num;
    //         cin >> num;
    //         S.push(num);
    //     }
    //     else if (strcmp(command, "top") == 0)
    //     {
    //         if (S.size() != 0)
    //             cout << S.top() << "\n";
    //         else
    //             cout << -1 << "\n";
    //     }
    //     else if (strcmp(command, "empty") == 0)
    //     {
    //         if (S.size() == 0)
    //             cout << 1 << '\n';
    //         else
    //             cout << 0 << "\n";
    //     }
    //     else if (strcmp(command, "size") == 0)
    //         cout << S.size() << "\n";
    //     else
    //     {
    //         if (S.size() != 0)
    //         {
    //             cout << S.top() << "\n";
    //             S.pop();
    //         }
    //         else
    //             cout << -1 << "\n";
    //     }
    // }

    int N;
    cin >> N;

    while (N--)
    {
        string command;
        cin >> command;
        if (command == "push")
        {
            int num;
            cin >> num;
            arrayInt[pos] = num;
            pos++;
        }
        else if (command == "top")
        {
            if (pos != 0)
                cout << arrayInt[pos - 1] << "\n";
            else
                cout << -1 << "\n";
        }
        else if (command == "empty")
        {
            if (pos == 0)
                cout << 1 << '\n';
            else
                cout << 0 << "\n";
        }
        else if (command == "size")
            cout << pos << "\n";
        else
        {
            if (pos != 0)
            {
                cout << arrayInt[pos - 1] << "\n";
                pos--;
            }
            else
                cout << -1 << "\n";
        }
    }
}