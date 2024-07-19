

#include <iostream>
#include <limits.h>
#include <vector>
#include <string>
using namespace std;
char chSet[10];
int arr[10] = { 0,1,2,3,4,5,6,7,8,9 };
bool visit[10] = { false };
vector<int> v;
string resultMax, resultMin;
long long minValue = LLONG_MAX, maxValue = LONG_MIN;
int K;
void solve(int num, string s) {
    if (num == K+1) {

        long long result = stoll(s);
        if (maxValue < result) {
            maxValue = result;
            resultMax = s;
        }
        if (minValue > result) {
            minValue = result;
            resultMin = s;
        }
       
        return;
    }
    
    for (int i = 0; i < 10; i++) {
        if (num == 0) {
            if (!visit[i]) {
                visit[i] = true;
                solve(num + 1, to_string(i));
                visit[i] = false;
            }
        }
        else {
            if (!visit[i]) {
                if (chSet[num - 1] == '<') {
                    if (s[num - 1]-'0' > i) {
                        continue;
                    }
                }
                else if (chSet[num - 1] == '>') {
                    if (s[num - 1]-'0' < i) {
                        continue;
                    }
                }
                visit[i] = true;
                solve(num + 1, s+to_string(i));
                visit[i] = false;
            }
        }
    }
}
int main()
{
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> K;
    
    for (int i = 0; i < K; i++) {
        char ch;
        cin >> ch;
        chSet[i] = ch;
    }


    solve(0, "");

    cout << resultMax << '\n';
    cout << resultMin << '\n';
}
