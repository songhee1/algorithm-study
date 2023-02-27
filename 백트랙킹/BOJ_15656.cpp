#include <bits/stdc++.h>
using namespace std;
int N, M;
int arr[10];
int answer[10];
int isused[10];
void func(int k)
{
    if (k == M)
    {

        for (int i = 0; i < M; i++)
        {
            cout << answer[i] << ' ';
        }
        cout << "\n";
        return;
    }
    int tmp = 0;
    for (int i = 0; i < N; i++)
    {
        if (tmp != arr[i])
        {
            if (k == 0 || (k != 0 && answer[k - 1] <= arr[i]))
            {
                answer[k] = arr[i];
                tmp = answer[k];
                func(k + 1);
                answer[k] = 0;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + N);
    func(0);
}