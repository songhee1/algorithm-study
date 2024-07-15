#include <iostream>
using namespace std;
bool arr[10001] = { false };

void checkIsSelfNumber(int num) {
    int result = num;
    int mok = 1;
    int namu = 1;
    while (mok != 0) {
        mok = num / 10;
        namu = num % 10;
        result += namu; //1555-> 100
        num = mok;

        if (result > 10000) {
            return;
        }
    }

    if (!arr[result]) {
        arr[result] = true;
        checkIsSelfNumber(result);
    }
}
int main()
{
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    for (int i = 1; i <= 10000; i++) {
        if (!arr[i]) {
            checkIsSelfNumber(i);
        }
    }

    for (int i = 1; i <= 10000; i++) {
        if (!arr[i]) {
            cout << i << "\n";
        }
    }
}
