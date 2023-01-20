#include <iostream>
#include <list>
using namespace std;
int main()
{
    string s;
    cin >> s;
    list<char> L;
    for (int i = 0; i < s.length(); i++)
    {
        L.push_back(s[i]);
    }
    list<char>::iterator t = L.end();
    t--;
    // cout << "t가 가리키는 원소는 :" << *t << '\n';

    int M;
    cin >> M;
    char command[3], alpha[3];

    for (int i = 0; i < M; i++)
    {
        cin >> command[i];
        if (command[i] == 'P')
        {
            cin >> alpha[i];
            // t가 마지막 원소이면 뒤에 추가(push_back(element))
            if (t == (L.end()--))
            {
                L.push_back(alpha[i]);
                t++;
                // cout << "t가 가리키는 원소는 :" << *t << '\n';
            }
            else
            {
                t++;
                // 가운데에 원소 추가시
                L.insert(t, alpha[i]);
                t--;
            }
        }
        else if (command[i] == 'L')
        { // 커서 왼쪽 이동(L):
            if (*t != L.front())
                t--;
        }
        else if (command[i] == 'D')
        { // 커서 오른쪽 이동(D):
            if (*t != L.back())
                t++;
        }
        else
        {
            if (t != (L.begin()--))
            {
                t = L.erase(t);
                if (t != (L.begin()))
                    t--;
            }
        }
    }
    for (auto i : L)
        cout << i;
}
