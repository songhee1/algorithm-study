using namespace std;
#include <iostream>
#include <vector>
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> v3 = {1, 2, 3, 4};
    v3.erase(v3.begin() + 2);
    v3.clear();
    for (auto i : v3)
        cout << i << ' ';
}
