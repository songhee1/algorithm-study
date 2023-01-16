using namespace std;
#include<iostream>

int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);
   int a[10]={};
   string s;
   cin>>s;
   int setNum=0;
   for(int i=0;i<s.length();i++){
    if( a[s[i]-48]==0) {
        setNum++;
        a[s[i]-48]=1;
    }else if(a[s[i]-48]==1){
        if(s[i]-48==6){
            
        }
    }
   }
}