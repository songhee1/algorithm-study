#include<bits/stdc++.h>
int N, tmp;
int a[10000005];
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++){
        cin>>a[i];
    }
    for(int i=0;i<N-1;i++){
        for(int j=i+1;j<N;j++){
            if(a[j]<a[i]){
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
    }
    for(int i=0;i<N;i++){
        cout<<a[i]<<"\n"
        ;
    }
}