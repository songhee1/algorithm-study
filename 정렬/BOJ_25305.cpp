#include<bits/stdc++.h>
using namespace std;
int N, k;
int a[1005];
int tmp;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>k;
    for(int i=0;i<N;i++){
        cin>>a[i];
    }
    for(int i=0;i<N-1;i++){
        for(int j=i+1;j<N;j++){
            if(a[i]<a[j]){
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;        
            }
        }
    }
    cout<<a[k-1];

}