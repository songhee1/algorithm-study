#include <string>
#include <vector>
#include<bits/stdc++.h>

using namespace std;

void solution(string s) {
    vector<int> answer;
    vector<int> arr[25];
    for(int i=0;i<s.size();i++){
        if(arr[s[i]-97].size()==0){
            arr[s[i]-97].push_back(i); 
            answer.push_back(-1);
        }else{
            answer.push_back(i-arr[s[i]-97][0]);
            arr[s[i]-97].pop_back();
            arr[s[i]-97].push_back(i);
        }
        
    }
    for(auto i:answer){
        cout<<i<<' ';
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s="baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    solution(s);
}