#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>

using namespace std;
int N, d, K, C;
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> N >> d >> K >> C;

	int main[3001] = { 0 };
	deque<int> d;
	deque<int> one;
	int num = 0;
	int varity = 0;
	int result = 0;
	for (int i = 0; i < K; i++) {
		cin >> num;
		d.push_back(num);
		one.push_back(num);
		main[num]++;
		if (main[num] == 1) {
			varity++;

		}
	}
	result = max(result, varity);
	for (int l = 0; l < N-K; l++) {
		cin >> num;
		d.push_back(num);
		one.push_back(num);
		main[num]++;
		if (main[num] == 1) {
			varity++;
		}

		int front = d.front();
		main[front]--;
		if (main[front] == 0) {
			varity--;
		}
		d.pop_front();

		main[C]++;
		if (main[C] == 1) {
			varity++;
		}
		result = max(result, varity);
	
	}
	for (int l = N - K; l < N; l++) {
		int front = one.front();
		main[front]++;
		d.push_back(front);
		if (main[front] == 1) {
			varity++;
		}

		int d_front = d.front();
		main[d_front]--;
		if (main[d_front] == 0) {
			varity--;
		}
		d.pop_front();
		one.pop_front();

		main[C]++;
		if (main[C] == 1) {
			varity++;
		}
		result = max(result, varity);
	}

	cout << result;
}
