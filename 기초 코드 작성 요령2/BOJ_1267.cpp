#include <iostream>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, a[20], realA[20], totalSumYongSik, totalSumMinSik;
    totalSumYongSik = 0;
    totalSumMinSik = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
        realA[i] = a[i];
        while (true)
        {
            if (a[i] < 30)
            {
                totalSumYongSik += 10;
                break;
            }
            else if (a[i] >= 30)
            {
                totalSumYongSik += 20;
                a[i] -= 59;
                if (a[i] < 0)
                    break;
            }
        }
        a[i] = realA[i];
        while (true)
        {
            if (a[i] < 60)
            {
                totalSumMinSik += 15;
                break;
            }
            else if (a[i] >= 60)
            {
                totalSumMinSik += 30;
                a[i] -= 119;
                if (a[i] < 0)
                    break;
            }
        }
    }
    if (totalSumYongSik > totalSumMinSik)
        cout << "M"
             << " " << totalSumMinSik;
    else if (totalSumYongSik < totalSumMinSik)
        cout << "Y"
             << " " << totalSumYongSik;
    else
        cout << "Y M"
             << " " << totalSumMinSik;
}