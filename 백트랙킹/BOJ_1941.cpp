#include <bits/stdc++.h>
using namespace std;

char arr[5][5];
int num[25];
int answer[7];
int isused[25];

int isvisited[5][5];
int ishere[5][5];

int cnt;
queue<pair<int, int>> q;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
bool iscloseEachother()
{
    int closednum = 1;
    while (!q.empty())
    {
        pair<int, int> cur = q.front();
        cout << '(' << cur.first << ", " << cur.second << ") ";
        q.pop();
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                continue;
            if (ishere[nx][ny] == 0 || isvisited[nx][ny] == 1)
                continue;
            isvisited[nx][ny] = 1;
            q.push({nx, ny});
            closednum++;
        }
    }
    if (closednum != 7)
        return false;
    else
        return true;
}
void func(int k)
{
    if (k == 7)
    {
        int row = 0;
        int column = 0;
        int snum = 0;
        for (int i = 0; i < 7; i++)
        {
            row = answer[i] / 5;
            column = answer[i] % 5;
            cout << row << ',' << column << "\n";
            if (arr[row][column] == 'S')
            {
                snum++;
            }
        }
        return;
        // if (snum < 4)
        //     return;
        // else if (snum >= 4)
        // {
        //     cout << "this is more than four\n";
        //     return;
        // for (int i = 0; i < 7; i++)
        // {
        //     row = answer[i] / 5;
        //     column = answer[i] % 5;
        //     cout << row << ", " << column << "\n";
        // }
        // cout << "\n";
        // return;
        // }

        // if (snum < 4)
        //     return;
        // else
        // {
        //     for (int i = 0; i < 5; i++)
        //     {
        //         fill(isvisited[i], isvisited[i] + 5, 0);
        //         fill(ishere[i], ishere[i] + 5, 0);
        //     }
        //     for (int i = 0; i < 7; i++)
        //     {
        //         row = answer[i] / 5;
        //         column = answer[i] % 5;
        //         ishere[row][column] = 1;
        //         if (i == 0)
        //         {
        //             q.push({row, column});
        //             isvisited[row][column] = 1;
        //         }
        //     }
        //     if (iscloseEachother())
        //     {
        //         cnt++;
        //         return;
        //     }
        //     else
        //         return;
        // }
    }
    for (int i = 0; i < 25; i++)
    {
        if (!isused[i])
        {
            if (k == 0 || (k != 0 && answer[k - 1] < num[i]))
            {
                isused[i] = 1;
                answer[k] = num[i];
                func(k + 1);
                isused[i] = 0;
                answer[k] = 0;
            }
        }
    }
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {

            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < 25; i++)
    {
        num[i] = i;
    }
    for (int i = 0; i < 25; i++)
    {
        cout << num[i] << ", ";
    }
    func(0);
    // cout << cnt;
}