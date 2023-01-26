#include <iostream>
#include <queue>
using namespace std;
queue<int> Q;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    for(int i=1;i<=N;i++) Q.push(i);
    while(Q.size()!=1){
        Q.pop();
        int onTheTopNum=Q.front();
        Q.pop();
        Q.push(onTheTopNum);
    }
    cout<<Q.front();
}