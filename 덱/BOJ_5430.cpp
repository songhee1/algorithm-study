#include <iostream>
#include <deque>
#include <string>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T, n;
    cin >> T;
    // 테스트 케이스 갯수만큼 반복
    while (T--)
    {
        string array, p;
        string error = "";
        deque<char> Q;

        // 수행할 함수
        cin >> p;

        // 배열에 들어있는 수의 갯수
        cin >> n;

        // 배열에 들어가는 정수들 ex. [1,2,3,4]
        cin >> array;

        //'[' 제거
        array.erase(array.begin());
        //']'제거
        array.erase(array.end() - 1);

        // 문자열에 들은 char형 정수들 Q에 push
        for (auto i : array)
        {
            if (i != ',')
            {
                Q.push_back(i);
            }
        }
        // 이터레이터를 맨 뒤 원소로 고정
        auto it = Q.end() - 1;
        // 함수에 따라 동작
        for (auto i : p)
        {
            if (i == 'R')
            {

                while (1)
                {
                    // 반복자가 덱의 맨 앞을 가리킬 경우
                    if (it == Q.begin())
                    {
                        Q.push_back(*it);
                        Q.pop_front();
                        break;
                    }
                    // 반복자 위치를 앞으로 땡기고 맨뒤로 PUSH&해당 원소 제거
                    Q.push_back(*(--it));
                    Q.erase(it);
                }
                for (auto i : Q)
                    cout << i << " ";
                cout << '\n';
            }
            else if (i == 'D')
            {
                if (Q.empty())
                {
                    error = "error";
                    break;
                }
                Q.pop_front();
                for (auto i : Q)
                    cout << i << " ";
                cout << '\n';
            }
        }
        if (error != "")
        {
            cout << error;
        }
        else
        {
            cout << '[';
            for (int i = 0; i < Q.size(); i++)
            {
                if (i != Q.size() - 1)
                    cout << Q[i] << ',';
                else
                    cout << Q[i];
            }
            cout << ']' << "\n";
        }
    }
}