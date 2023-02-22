#include <bits/stdc++.h>
using namespace std;
int T;
int score[101];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        int testcasenum=0;
        cin>>testcasenum;
        memset(score, 0, sizeof(score));
        for (int j = 1; j <= 1000; j++)
        {
            int num;
            cin >> num;
            score[num]++;
        }
        int lotofcomout = 0;
        for (int k = 1; k <= 100; k++)
        {
            if(score[lotofcomout]<score[k]){
                lotofcomout=k;
            }
        }
        cout<<"#"<<i<<" "<<lotofcomout<<"\n";
    }
}