#include <stdlib.h>
#include <iostream>
#include <algorithm>

using namespace std;
int N, B, W, r, len;
string road;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> B >> W >> road;
	for (int l = 0; l < road.length(); l++) {
		int ray[100] = { 0 };
		r = l;
		while (r < road.length()) {
			char ch = road[r];
			if (ch == 'B') {
				if (ray['B'-0] + 1 <= B) {
					ray['B'-0]++;
					if (ray['W' - 0] >= W) {
						len = max(len, r - l + 1);
					}
				}
				else {
					break;
				}
			}
			else {
				ray['W'-0]++;
				if (ray['W' - 0] >= W) {
					len = max(len, r - l + 1);
				}
			}
			r++;
		}

		if (r == road.length()) {
			break;
		}
	}
	
	cout << len;
	
}
