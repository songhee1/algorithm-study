#include <bits/stdc++.h>
using namespace std;
int N, S;
int cnt;
int arr[30];
int isused[30];
int cur = 2;
int result;
int answer[30];
void func(int k)
{
    if (k == cur)
    {
        for (int i = 0; i < N; i++)
        {
            if (isused[i])
                result += arr[i];
        }
        if (result == S)
        {
            cnt++;
        }
        result = 0;
        for (int i = 0; i < k; i++)
        {
           cout<<answer[i]<<' ';
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; i++)
    {
        if (!isused[i])
        {
            isused[i] = 1;
            answer[k]=arr[i];
            func(k + 1);
            isused[i] = 0;
            answer[k]=0;
            if(i==N-1){
                cur++;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> S;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    func(0);
    cout << cnt;
}