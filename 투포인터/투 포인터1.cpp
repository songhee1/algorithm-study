#include <bits/stdc++.h>
/*
- left : 주어진 문자열의 시작점 인덱스 역할
- right : 인덱스 left부터 최대 N까지 도달할때까지 최대 길이 구하는 역할

[범위]
0<=left<string.length()
left<=right<string.length()
count <= N

[반복]
right<string.length(), count <= N 를 만족시 아래를 수행
- arr[right-'a']++ 시 arr[right-'a']=1라면 count++
- 만약 count>N 이면 탈출
- result 갱신
- right++

*/

using namespace std;
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N; // 인식가능한 알파벳 종류의 최대값
	cin >> N;

	string s;
	cin >> s;

	int arr[27];
	int right, count, result = 0;
	for (int left = 0; left < s.length(); left++) {
		memset(arr, 0, sizeof(arr));
		count = 0;
		right = left;

		while (right < s.length() && count <= N) {
			arr[s[right] - 'a']++;
			if (arr[s[right] - 'a'] == 1) {
				count++;
			}
			if (count > N) {
				break;
			}

			result = max(result, right - left + 1);
			right++;
		}

		if (right == s.length()) {
			break;
		}
	}
	cout << result;
}
