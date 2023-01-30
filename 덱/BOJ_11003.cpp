#include <iostream>
#include <algorithm>
#include <deque>
using namespace std;
int N, L;
int numArray[5000000];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int> q;
    cin >> N >> L;
    for (int i = 1; i <= N; i++)
    {
        int num;
        cin >> num;
        numArray[i]=num;
    }
    
    for (int j = 1; j <= N; j++)
    {
        int minNum = 1000000000;
        int start_idx=j-L+1;
        int end_idx=j;

        for (int i=start_idx; i <= end_idx; i++)
        {
            if (i > 0)
            {
                minNum = min(minNum, numArray[i]);
            }
        }
        q.push_back(minNum);
    }
    for(auto i:q) cout<<i<<' ';
}