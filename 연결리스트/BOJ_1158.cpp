using namespace std;
#include <iostream>
#include <list>
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, k;
    cin >> N >> k;
    list<int> L;
    for (int i = 1; i <= N; i++)
        L.push_back(i);
    auto it = L.begin();
    cout << '<';

    while (L.size() != 0)
    {
        if (k == 1)
        {
            cout << *it;
            it = L.erase(it);
            if (L.size() != 0)
                cout << ", ";
        }
        else
        {
            for (int i = 1; i < k; i++)
            {
                if(L.size()==1) break;
                if (*it == L.back())
                {
                    it = L.begin();
                    
                }else it++;
            }
            cout << *it;
            it = L.erase(it);
            if(it==L.end()) it=L.begin();
            if (L.size() != 0)
                cout << ", ";
        }
    }
    cout << '>';
}