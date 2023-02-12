#include <bits/stdc++.h>
using namespace std;
int N;
int a[500005], tmp;
int average, middle, range, sum;
int many[4001], maxIdx, secondIdx, minNum, maxNum;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
        sum += a[i];
        many[a[i]]++;
    }

    for (int i = 1; i < N; i++)
    {
        if (many[i] > many[maxIdx])
        {
            maxIdx = i;
        }
        else if (many[i] == many[maxIdx])
        {
            if (i < maxIdx)
            {
                secondIdx = i;
            }
            if (maxIdx < i)
            {
                maxIdx = i;
                secondIdx = maxIdx;
            }
        }
    }
    for (int i = 0; i < N - 1; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            if (a[j] < a[i])
            {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
    cout << sum / N;
    cout << a[N / 2];
    cout << secondIdx ? secondIdx : maxIdx;
    cout<<a[N-1]-a[0];
}