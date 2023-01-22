#include <iostream>
#include <list>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int cases;
    cin >> cases;
    string passWord;
    while (cases)
    {
        list<char> L;
        cin >> passWord;
        auto it = L.begin();
        for (auto i : passWord)
        {
            if (i == '<')
            {
                if (it != L.begin())
                    it--;
            }
            else if (i == '>')
            {
                if (it != L.end())
                    it++;
            }
            else if (i == '-')
            {
                if (it != L.begin())
                {
                    it--;
                    it = L.erase(it);
                }
            }
            else
            {
                L.insert(it, i);
            }
        }
        for (auto i : L)
            cout << i;

        cout << '\n';
        cases--;
    }
}