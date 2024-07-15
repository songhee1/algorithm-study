#include <iostream>
#include <set>
using namespace std;

int main()
{
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    int num = 0;
     
    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        set<char> charSet;
        char nowChar = '\0';
        bool hasValue = false;
        for (int j = 0; j < s.length(); j++) {
            if (nowChar == s[j]) {
                continue;
            }else if (nowChar != s[j] && charSet.find(s[j]) != charSet.end()) {
                hasValue = true;
                break;
            }else if (nowChar == '\0' || charSet.find(s[j]) == charSet.end()) {
                charSet.insert(s[j]);
                nowChar = s[j];
            }
        }

        if (!hasValue) {
            num++;
        }

    }

    cout << num;
    
}
