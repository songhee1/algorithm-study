#include <iostream>
#include<cstdlib>
#include<vector>
using namespace std;
int N;
int arr[9];
bool visit[9] = { false };
vector<int> v;
int maxValue = INT_MIN;

void solve(int num) {
    if (num == N) {
        int result = 0;
        for (int i = 0; i < N-1; i++) {
            result += abs(v[i]-v[i+1]);
        }
        maxValue = max(maxValue, result);
        return;
    }

    for (int i = 1; i <= N; i++) {
        if (!visit[i]) {
            visit[i] = true;
            v.push_back(arr[i]);
            solve(num + 1);
            v.pop_back();
            visit[i] = false;
        }
    }
}
int main()
{
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    int num;
    for (int i = 1; i <= N; i++) {
        cin >> num;
        arr[i] = num;
    }

    solve(0);

    cout << maxValue;
}

