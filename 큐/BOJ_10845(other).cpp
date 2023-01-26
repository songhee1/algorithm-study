#include <iostream>
#include <queue>
using namespace std;

int array[100005];
int head,tail;
int main()
{
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
            array[tail]=num;
            tail++;
        }
        else if (command.compare("pop")==0)
        {
            if (tail-head == 0)
                cout << -1 << "\n";
            else
            {
                cout << array[head] << "\n";
                head++;
            }
        }
        else if (command.compare("size")==0)
            cout << tail-head << '\n';
        else if (command.compare("empty")==0)
        {
            if (tail-head == 0)
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }else if(command.compare("front")==0){
            if (tail-head == 0)
                cout << -1 << '\n';
            else
                cout << array[head] << '\n';
        }else{
             if (tail-head == 0)
                cout << -1 << '\n';
            else
                cout << array[tail-1] << '\n';
        }
    }
}