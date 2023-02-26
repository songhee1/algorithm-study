#include <bits/stdc++.h>
using namespace std;
int N, cnt;
int isused[20];
int isused1[20];
int isused2[35];
int isused3[35];
void func(int cur)
{
    if (cur == N)
    {
        cnt++;
        return;
    }

    for (int i = 0; i < N; i++)
    {
        if (isused1[cur]==0 && isused[i]==0 && isused2[i + cur]==0 && isused3[i - cur + N - 1]==0)
        {
            cout<<"func in"<<i<<" "<<cur<<"\n";
            isused[i]=1;
            isused1[cur] = 1;
            isused2[i + cur] = 1;
            isused3[i - cur+N-1] = 1;
            func(cur + 1);
            cout<<"func out"<<i<<" "<<cur<<"\n";
            isused[i]=0;
            isused1[cur] = 0;
            isused2[i + cur] = 0;
            isused3[i - cur+N-1] = 0;
        }
    }
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    func(0);
    cout<<cnt;
}