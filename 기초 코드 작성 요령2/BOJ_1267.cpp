#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, callingTerm;
    int yongsik = 0, minsik = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> callingTerm;
        yongsik += (callingTerm / 30 + 1) * 10;
        minsik += (callingTerm / 60 + 1) * 15;
    }
    if (yongsik > minsik)
        cout << 'M' << " " << minsik;
    else if (yongsik < minsik)
        cout << 'Y' << " " << yongsik;
    else
        cout << "Y M " << minsik;
}