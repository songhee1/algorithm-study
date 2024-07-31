#include <stdlib.h>
#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
/*
[범위]
0<=left<arr.length, left<=right<arr.length

[반복]
right< arr.length, count<=K
- 짝 : v 추가, result 갱신
- 홀 : count+1, count>K이면 탈출
- right++


*/

using namespace std;
int arr[1000001];
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int len = 0;
	int N, K, left, right, count, result = 0;
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	left = 0;
	right = 0;
	count = 0;

	while (left < N && right < N && left<=right) {
		while (right < N && count<=K) {
			if (arr[right+1] % 2 != 0) {
				if (count+1 > K) {
					right;
					break;
				}
				right++;
				count++;
			}
			else {
				len++;
				result = max(result, len);
			}
			
		}
		if (arr[left] % 2 == 0) {
			len--;
		}
		else {
			count--;
		}
		left++;
	}



	cout << result;
}

