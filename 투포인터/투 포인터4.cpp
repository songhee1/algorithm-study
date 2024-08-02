#include <stdlib.h>
#include <iostream>
#include <vector>
#include <set>

using namespace std;
int N, d, K, C, r, maxD = 0;
set<set<int>> globalSet;
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	vector<int> v;
	cin >> N >> d >> K >> C;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}

	for (int l = 0; l < N; l++) {
		set<int> s;
		r = l;
		int num = 0;

		while (num < K) {
			if (r >= N) {
				r = r % N;
			}
			s.insert(v[r]);
			r++;
			num++;
		}

		s.insert(C);
		int size = s.size();
		if (maxD < size) {
			globalSet.clear();
			globalSet.insert(s);
			maxD = size;
		}
		else if (maxD == size) {
			globalSet.insert(s);
		}

		if (maxD == K + 1) {
			break;
		}
	}

	cout << maxD;
}

