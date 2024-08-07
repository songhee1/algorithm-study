#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int R, C, T;
int map[50][50];
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };

struct xy {
	int x;
	int y;
};
void unclockDir(xy airConditionerUpper) {
	int x = airConditionerUpper.x;
	int y = airConditionerUpper.y;
	for (int i = airConditionerUpper.x; i >= 1; i--) {
		if (map[i][y] != -1) {
			map[i][y] = map[i - 1][y];
		}
	}
	for (int j = y; j < C - 1; j++) {
		map[0][j] = map[0][j + 1];
	}
	for (int i = 0; i < x; i++) {
		map[i][C - 1] = map[i + 1][C - 1];
	}
	for (int j = C - 1; j > 1; j--) {
		map[x][j] = map[x][j - 1];
	}
	map[x][1] = 0;
}
void outside() {
	// 확산
	int copyMap[50][50] = { 0 };
	copy(&map[0][0], &map[0][0] + 50, &copyMap[0][0]);
	
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j] != -1 && map[i][j] != 0) {
				int rest = map[i][j] / 5;
				int num = 0;
				vector<xy> v;
				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					num++;
					v.push_back({ nx, ny });
				}
				copyMap[i][j] = map[i][j] - rest * num;
 				for (xy inst : v) {
					copyMap[inst.x][inst.y] += rest;
				}

			}
		}
	}

	copy(&copyMap[0][0], &copyMap[0][0] + 50, &map[0][0]);
}
void clockDir(xy airConditionerLower) {
	int x = airConditionerLower.x;
	int y = airConditionerLower.y;
	for (int i = airConditionerLower.x; i < R - 1; i++) {
		if (map[i][y] != -1) {
			map[i][y] = map[i + 1][y];
		}
	}
	for (int j = y; j < C - 1; j++) {
		map[0][j] = map[0][j + 1];
	}
	for (int i = C - 1; i > x; i--) {
		map[i][C - 1] = map[i - 1][C - 1];
	}
	for (int j = C - 1; j > 1; j--) {
		map[x][j] = map[x][j - 1];
	}
	map[x][1] = 0;
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> R >> C >> T;
	xy airConditionerUpper;
	xy airConditionerLower;
	int n = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) {
				if (n == 0) {
					airConditionerUpper = { i, j };
					n++;
				}
				else airConditionerLower = { i, j };
			}
		}
	}

	for (int test = 0; test < T; test++) {
		//확산
		outside();

		cout << '\n';
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cout << map[i][j] << ' ';
			}
			cout << '\n';
		}

		//공청위 공간
		unclockDir(airConditionerUpper);
		//공청아 공간
		clockDir(airConditionerLower);
	}

	int sum = 0;
	cout << '\n';
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cout << map[i][j] << ' ';
			sum += map[i][j];
		}
		cout << '\n';
	}
	cout << sum+2;
}

