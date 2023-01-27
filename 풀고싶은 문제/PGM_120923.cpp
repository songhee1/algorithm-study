#include <string>
#include <vector>
#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> answer;
    auto it = answer.begin();
    int total, num;
    cin >> total >> num;
    int middleNum = total / num;
    auto middleNumIndex = it + num / 2;
    auto middleMinusNumIndex = it + (num / 2 - 1);
    if (total % num == 0)
        answer.insert(middleNumIndex, middleNum);
    else
        answer.insert(middleMinusNumIndex, middleNum);

    int i = 0;
    while (answer.size() != num)
    {
        if (it + i != middleNumIndex)
        {
            answer.insert(it + i, middleNum - (num / 2 - i));
            i++;
        }
        else
            i++;
    }
    string s = "[";
    for (int i = 0; i < answer.size(); i++)
    {
        if (i != answer.size() - 1)
            s += answer[i] + ", ";
        else
            s += answer[i] + "]";
    }
    cout << s;
}