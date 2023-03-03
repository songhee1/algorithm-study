#include <bits/stdc++.h>
using namespace std;
int x, y;
int squarex, squarey;
int minum=1000;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> x >> y;
    cin >> squarex >> squarey;
    minum=min(x,minum);
    minum=min(y, minum);
    minum=min(squarex-x,minum);
    minum=min(squarey-y,minum);
    cout<<minum;
}