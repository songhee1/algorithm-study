#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;
int N, K, t;
bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first == b.first) {
		return a.second < b.second;
	}
	else {
		return a.first < b.first;
	}
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> t;

	for (int i = 0; i < t; i++) {
		vector<int> v;
		cin >> N >> K;
		int result = 0;
		int num;
		for (int i = 0; i < N; i++) {
			cin >> num;
			v.push_back(num);
		}
		int l = 0;
		int r = N - 1;

		sort(v.begin(), v.end());
		map<long long, int> m;

		while (l < r) {
			long long sum = long long( abs(v[l] +v[r] - K));
 			if (m.find(sum) != m.end()) {
				m[sum]++;
			}
			else {
				m.insert(make_pair(sum, 1));
			}
			result = max(result, m[sum]);

			if (v[l] + v[r] > K) {
				r--;
			}
			else {
				l++;
			}
		}

		cout << result << '\n';
	}
	
}

