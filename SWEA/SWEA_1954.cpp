#include<bits/stdc++.h>
int T,N;
int row, column;
int dist[13][13];
using namespace std;

void 

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int i=1;i<=T;i++){
        cin>>N;
        dist[0][0]=1;
        
    }

    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cout<<dist[i][j]<<" ";
        }
        cout<<"\n";
    }
}