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
    // cout << "t�� ����Ű�� ���Ҵ� :" << *t << '\n';

    int M;
    cin >> M;
    char command[3], alpha[3];

    for (int i = 0; i < M; i++)
    {
        cin >> command[i];
        if (command[i] == 'P')
        {
            cin >> alpha[i];
            // t�� ������ �����̸� �ڿ� �߰�(push_back(element))
            if (t == (L.end()--))
            {
                L.push_back(alpha[i]);
                t++;
                // cout << "t�� ����Ű�� ���Ҵ� :" << *t << '\n';
            }
            else
            {
                t++;
                // ����� ���� �߰���
                L.insert(t, alpha[i]);
                t--;
            }
        }
        else if (command[i] == 'L')
        { // Ŀ�� ���� �̵�(L):
            if (*t != L.front())
                t--;
        }
        else if (command[i] == 'D')
        { // Ŀ�� ������ �̵�(D):
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
