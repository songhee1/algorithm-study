#include<bits/stdc++.h>
using namespace std;
int N,M;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    int num[N];
    memset(num, 0, sizeof(num));
    for(int i=1;i<=N;i++){
        num[i]=i;
    }
    for(int i=1;i<=N;i++){
        cout<<num[i]<<" ";
        if(M>=2){
            for(int j=2;j<=N;j++){
                cout<<num[j];
            }
            if(M>=3){
                for(int j=)
            }
        }
    }
}