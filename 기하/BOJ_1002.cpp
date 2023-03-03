#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T, x1, y1, r1;
    int x2, y2, r2;
    int sum, dist, mvalue;
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        cin >> x1 >> y1 >> r1;
        cin >> x2 >> y2 >> r2;
        sum = (r1 + r2) * (r1 + r2);
        dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        mvalue = (r1 - r2) * (r1 - r2);
        if (sum == dist || mvalue == dist)
            cout << 1;
        else if (mvalue < dist && dist < sum)
            cout << 2;
        else if(r1==r2&& dist==0)
            cout << -1;
        else cout<<0;
        cout << "\n";
    }
}