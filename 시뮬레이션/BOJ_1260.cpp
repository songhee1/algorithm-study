#include <bits/stdc++.h>
using namespace std;
int N,M,V;
vector<int>graph[1005];
bool visited[1005];

queue<int> q;

void dfs(int node){
    if(visited[node]==1){
        return;
    }
    visited[node]=1;
    cout<<node<<' ';
    
    for(int i=0;i<graph[node].size();i++){
        dfs(graph[node][i]);        
    }
}

void bfs(int node){
   q.push(node);
   visited[node]=1;
   while(!q.empty()){
     int cur=q.front(); q.pop();
     cout<<cur<<' ';
     for(int i=0;i<graph[cur].size();i++){
        if(visited[graph[cur][i]]==1) continue;
        visited[graph[cur][i]]=1;
        q.push(graph[cur][i]);
     }
   }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M>>V;
     for(int i=0;i<M;i++){
       int a,b;
       cin>>a>>b;
       graph[a].push_back(b);
       graph[b].push_back(a);  
    }
    for(int i=0;i<N;i++){
        sort(graph[i].begin(), graph[i].end());
    }
    dfs(V);
    fill(visited, visited+1005,false);
    cout<<"\n";
    bfs(V);
}