#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int T, K, n, d;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> T;
	int arr[1001][8] = { 0 };
	//vector<vector<int>> arr(T + 1, vector<int>(8,0));

	for (int test = 1; test <= T; test++) {
		string s;
		cin >> s;
		for (int i = 0; i < 8; i++) {
			arr[test][i] = s[i] - '0';
			
		}
	}

	cin >> K;
	for (int i = 1; i <= K; i++) {
		cin >> n >> d;
		int rot[1001] = { 0 };
		rot[n] = d;
		int dir = n+1;
		while (dir < T+1) {//회전시킨 톱니n에 오면 탈출
			if (arr[dir][6] != arr[dir - 1][2]) {
				//NS 극인 경우
				if (rot[dir - 1] == 1) {
					rot[dir] = -1;
				}
				else if(rot[dir-1] == -1) {
					rot[dir] = 1;
				}
			} //NN극이나 SS극이면 넘어감
			// 톱니 변수 이동
			dir++;
		}

		dir = n - 1;
		while (dir > 0) {
			if(arr[dir][2] != arr[dir + 1][6]) {
				//NS 극인 경우
				if (rot[dir + 1] == 1) {
					rot[dir] = -1;
				}
				else if (rot[dir + 1] == -1) {
					rot[dir] = 1;
				}
			}
			dir--;
		}

		for (int i = 1; i <= T; i++) {
			if (rot[i] == -1) {
				int tmp = arr[i][0];
				int index = 1;
				while (index <= 7) {
					arr[i][index - 1] = arr[i][index];
					index++;
				}
				arr[i][7] = tmp;
			}
			else if (rot[i] == 1) {
				int tmp = arr[i][7];
				int index = 7;
				while (index >= 0) {
					arr[i][index] = arr[i][index - 1];
					index--;
				}
				arr[i][0] = tmp;
			}
		}
	}

	int result = 0;
	for (int i = 1; i <= T; i++) {
		if (arr[i][0] == 1) result++;
	}

	cout << result;
}

