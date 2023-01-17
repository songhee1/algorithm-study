using namespace std;
#include <iostream>
#include <algorithm>
#include <vector>
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> v = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    string N;
    cin >> N;
    for (int i = 0; i < N.length(); i++)
    {
        v.erase(remove(v.begin(), v.end(), N[i] - 48));
    }
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i];
    }
}