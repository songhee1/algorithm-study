#include <iostream>
#include <queue>
#include <string>
#include <tuple>
using namespace std;
int H, W;
int arr[501];
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> H >> W;
	for (int i = 0; i < W; i++) {
		cin >> arr[i];
	}

	int total = 0;
	for (int i = 1; i < W-1; i++) {
		int left = 0;
		int right = 0;
		for (int j = 0; j < i; j++) {
			left = max(left, arr[j]);
		}
		for (int j = i + 1; j < W; j++) {
			right = max(right, arr[j]);
		}

		int calc = min(left, right) - arr[i];
		if (calc > 0) {
			total += calc;
		}
	}

	cout << total;
}

