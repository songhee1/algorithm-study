#include <iostream>
#include <queue>
#include <string>
#include <tuple>
using namespace std;
int dz[6] = { 0,0,0,0,1,-1 };
int dx[6] = { 1,0,-1,0,0,0 };
int dy[6] = { 0,1,0,-1,0,0 };
char arr[31][31][31];
int L, R, C;
int q, x, y;
bool visit[31][31][31];



string bfs(int i, int j, int k) {
	queue<tuple<int, int, int, int>> q;
	q.push(make_tuple(i, j, k, 0));
	visit[i][j][k] = true;
	int time = 0;

	while (!q.empty()) {
		int a = get<0>(q.front());
		int b = get<1>(q.front());
		int c = get<2>(q.front());
		int cnt = get<3>(q.front());
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nz = dz[i] + a;
			int nx = dx[i] + b;
			int ny = dy[i] + c;

			if (nz <= 0 || nz > L || nx <= 0 || nx > R || ny <= 0 || ny > C) continue;
			if (visit[nz][nx][ny] == true || arr[nz][nx][ny] == '#') {
				continue;
			}

			visit[nz][nx][ny] = true;
			if (arr[nz][nx][ny] == 'E') {
				time = cnt + 1;
				return "Escaped in" + to_string(time) + " minute(s).";
			}
		}
	}

	return "Trapped!";
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (true) {
		cin >> L;
		cin >> R;
		cin >> C;

		if (L == 0 && R == 0 && C == 0) break;
		memset(visit, false, sizeof(visit));
		memset(arr, '.', sizeof(arr));
		
		for (int i = 1; i <= L; i++) {
			string s;
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					cin >> s;
					arr[i][j][k] = s[k];
					if (arr[i][j][k] == 'S') {
						q = i;
						x = j;
						y = k;
					}
				}
			}
		}

		cout << bfs(q, x, y) << '\n';

	}
}

