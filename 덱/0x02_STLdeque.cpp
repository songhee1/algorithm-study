#include<iostream>
#include<deque>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int>DQ;
    DQ.push_front(10);
    DQ.push_back(50);
    DQ.push_front(24);
    cout<<DQ.size()<<'\n';
    if(DQ.empty()) cout<<"DQ IS EMPTY";
    else cout<<"DQ IS NOT EMPTY";
    DQ.pop_front();
    DQ.pop_back();
    cout<<DQ.back();
    DQ.push_back(72);
    DQ[2];
    DQ.clear();

    
}