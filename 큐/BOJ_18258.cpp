#include<iostream>
#include<queue>
using namespace std;

queue<int> Q;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
     int N;
    cin >> N;

    while (N--)
    {
        string command;
        cin >> command;
        if (command.compare("push")==0)
        {
            int num;
            cin >> num;
            Q.push(num);
        }
        else if (command.compare("pop")==0)
        {
            if (Q.size() == 0)
                cout << -1 << "\n";
            else
            {
                cout << Q.front() << "\n";
                Q.pop();
            }
        }
        else if (command.compare("size")==0)
            cout << Q.size() << '\n';
        else if (command.compare("empty")==0)
        {
            if (Q.size() == 0)
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }else if(command.compare("front")==0){
            if (Q.size() == 0)
                cout << -1 << '\n';
            else
                cout << Q.front() << '\n';
        }else{
             if (Q.size() == 0)
                cout << -1 << '\n';
            else
                cout << Q.back() << '\n';
        }
    }
}