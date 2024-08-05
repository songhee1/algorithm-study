#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int N, M, x, y, K;
           //  동 서  북  남
int dx[] = { 0, 0, 0, -1, 1};
int dy[] = { 0, 1, -1, 0, 0};

int dice[] = { 0,0,0,0,0,0 };

int map[20][20];

struct xy {
	bool move;
	int xx;
	int yy;
};
xy canMove(int dir) { //범위를 벗어나는지 확인
	int nx = x + dx[dir];
	int ny = y + dy[dir];
	if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
		return { false, 0, 0 };
	}
	else {
		return { true, nx, ny };
	}
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> N >> M >> x >> y >> K;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}

	int dir = 0;
	for (int i = 0; i < K; i++) {
		cin >> dir;
		xy tmp = canMove(dir);
		if (!tmp.move) {
			continue;
		}
		x = tmp.xx;
		y = tmp.yy;

		if (dir == 1) {
			int tm = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = tm;
		}
		else if (dir == 2) {
			int tm = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = tm;
		}
		else if (dir == 3) {
			int tm = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = tm;
		}
		else {
			int tm = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = tm;
		}

		if (map[x][y] == 0) {
			map[x][y] = dice[5];
		}
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}

		cout << dice[0] << '\n';
	}
}

