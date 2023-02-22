#include <bits/stdc++.h>
using namespace std;
int N;
int testcase = 10;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int list[1002] = {};
    for(int i=1;i<=testcase;i++)
    {
        cin >> N;
        memset(list,0,sizeof(list));

        for(int i=0;i<N;i++){
            cin>>list[i];
        }

        int num = 0;
        int chai = 0;
        for (int i = 2; i < N-2; i++)

        {
            if (list[i - 2] < list[i] && list[i - 1] < list[i] && list[i + 1] < list[i] && list[i + 2] < list[i])
            {
                int chainat = list[i];
                chainat = min(chainat, list[i] - list[i - 2]);
                chainat = min(chainat, list[i] - list[i - 1]);
                chainat = min(chainat, list[i] - list[i + 1]);
                chainat = min(chainat, list[i] - list[i + 2]);
                chai += chainat;
            }
        }
        cout << "#"<<i<<" "<<chai;
    }
    return 0;
}