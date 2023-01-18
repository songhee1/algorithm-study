#include <iostream>
#include <algorithm>
using namespace std;
int freq[26];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    char alpha = 'a';
    string s;
    cin >> s;
    // for (int i = 0; i < 26; i++)
    // {
    //     cout << count(begin(s), end(s), alpha + i) << ' ';
    // }

    for (auto c : s)
        freq[c - 'a']++;

    for (int i = 0; i < 26; i++)
    {
        cout << freq[i] << ' ';
    }
}