#include <bits/stdc++.h>
using namespace std;
int N;
int Bigger(int A, int B){
    if(A>B) return A;
    else return B;
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int list[1002] = {};
    int testcase = 1;
    for(int i=1;i<=testcase;i++)
    {
        cin >> N;
        memset(list,0,sizeof(list));

        for(int j=0;j<N;j++){
            cin>>list[j];
        }
        
        int sum=0;
        for (int j = 2; j < N-2; j++)
        {
            if (list[j - 2] < list[j] && list[j - 1] < list[j] && list[j + 1] < list[j] && list[j + 2] < list[j])
            {
                int BigSideNum=Bigger(list[j-2],Bigger(list[j-1],Bigger(list[j+1], list[j+2])));
                int n=list[j]-BigSideNum;
                sum+=n;
                
            }
        }
        cout << "#"<<i<<" "<<sum;
    }
    return 0;
}