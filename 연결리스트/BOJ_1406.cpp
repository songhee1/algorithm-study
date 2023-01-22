#include <iostream>
#include <list>
using namespace std;
int main()
{
    string s;
    cin >> s;
    list<char> L;
    for (auto i : s)
    {
        L.push_back(i);
    }
    int M;
    cin >> M;
    list<char>::iterator t = L.end();

    char command;
    char alpha;
    for (int i = 0; i < M; i++)
    {
        cin >> command;
        if (command == 'L')
        {
            if (t != L.begin())
                t--;
        }
        else if (command == 'D')
        {
            if (t != L.end())
                t++;
        }
        else if (command == 'P')
        {
            cin >> alpha;
            L.insert(t, alpha);
        }
        else
        {
            if (t != L.begin())
            {
                t--;
                t = L.erase(t);
            }
        }
    }
    for (auto i : L)
        cout << i;
}
