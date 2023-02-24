#include <bits/stdc++.h>
using namespace std;
int N, S;
int cnt;
int arr[30];
int ans[30];
int isused[30];
int result;
void func(int k){
   
   if(result==S) cnt++;

    for(int i=0;i<N;i++){
        if(!isused[i]){
            isused[i]=1;
            ans[i]=arr[i];
            func(k+1);
            isused[i]=0;
        }
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>S;
    for(int i=0;i<N;i++){
        cin>>arr[i];
    }
}