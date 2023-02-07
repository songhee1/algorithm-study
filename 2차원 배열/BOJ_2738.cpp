#include <bits/stdc++.h>
using namespace std;
int N, M;
int board[100][100];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < M; k++)
            {
                int num=0;
                cin >> num;
                board[j][k] +=  + num;
            }
        }
    }

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cout<<board[i][j]<<' ';
        }
        cout<<"\n";
    }
}