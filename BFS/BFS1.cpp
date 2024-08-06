#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int N, M, maxSum, virusNum;
bool visit[8][8];
struct xy {
	int x;
	int y;
};
vector<xy> v;
vector<vector<int>> map;
vector<vector<int>> copyMap;
bool virusVisit[8][8];
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
void runQueue(xy ins) {
	queue<xy> q;
	q.push(ins);
	virusVisit[ins.x][ins.y] = true;

	while (!q.empty()) {
		xy in = q.front();
		virusNum++;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = in.x + dx[i];
			int ny = in.y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (virusVisit[nx][ny] == false && copyMap[nx][ny] == 0) {
				virusVisit[nx][ny] = true;
				copyMap[nx][ny] = 2;
				q.push({ nx, ny });
			}
		}
	}

}
int bfs() {
	virusNum = 0;
	memset(virusVisit, false, sizeof(virusVisit));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (copyMap[i][j] == 2 && virusVisit[i][j] == false) {
				runQueue({ i, j });
			}
		}
	}

	return N * M - virusNum - v.size() - 3;
}
void dfs(int n) {
	if (n == 3) {
		//copy(map.begin(), map.end(), copyMap.begin());
		copyMap = map;

		maxSum = max(maxSum, bfs());
		return;
	}

	for (int i = 0; i < v.size(); i++) {
		xy instance = v[i];
		if (!visit[instance.x][instance.y]) {
			visit[instance.x][instance.y] = true;
			map[instance.x][instance.y] = 1;
			dfs(n + 1);
			visit[instance.x][instance.y] = false;
			map[instance.x][instance.y] = 0;
		}
	}
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> N >> M;
	map.assign(N, vector<int>(M));
	copyMap.assign(N, vector<int>(M));
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 0) {
				v.push_back({ i, j });
			}
		}
	}

	dfs(0);
	cout << maxSum;
}

