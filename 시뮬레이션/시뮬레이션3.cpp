#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <set>
#include <queue>

using namespace std;
/// <summary>
/// 1. (N,1), (N,2), (N-1,1), (N-1,2) 위치를 vector에 저장
/// 
/// 
/// 2. 이동
/// for문 돌면서 이동하는데, x가 1보다 작다면 x는 N, x가 N보다 크다면 x는1,
/// y가 1보다 작다면 y는 N, y는 N보다 크다면 y는 1
/// 3. vector 위치 모두 map값 1씩 증가
/// 4. vector 위치 돌면서 범위 벗어나지 않는 선에서 대각선 갯수 세어
/// map값 증가
/// 5. 전체 map에 대해 물이 >=2이면서 vector에 없는 값이면 
/// 새 vector를 만들어서 추가
/// </summary>
/// <returns></returns>
struct xy {
	int x;
	int y;
};
int dx[] = { 0,0,-1,-1,-1,0,1,1,1 };
int dy[] = { 0,-1,-1,0,1,1,1,0,-1 };
int main() {
	int N, M;
	int map[51][51] = { 0 };
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> N >> M;
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			cin >> map[i][j];
		}
	}
	
	set<xy> st;
	st.insert({ N, 1 });
	st.insert({ N,2 });
	st.insert({ N - 1,1 });
	st.insert({ N - 1,2 });
	int d, s;
	for (int i = 1; i <= M; i++) {
		cin >> d >> s;
		set<xy> tmp;
		for (xy ins : st) {
			int x = ins.x;
			int y = ins.y;
			for (int j = 0; j < s; j++) {
				x += dx[d];
				y += dy[d];
				if (x < 1) {
					x = N;
				}
				if (x > N) {
					x = 1;
				}
				if (y < 1) {
					y = N;
				}
				if (y > N) {
					y = 1;
				}
			}
			tmp.insert({ x, y });
			map[x][y]++;
		}

		for (xy ins : tmp) {
			int num = 0;
			for (int dir = 0; dir < 9; dir++) {
				if (dir % 2 == 0) {
					int nx = ins.x + dx[dir];
					int ny = ins.y + dy[dir];
					if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
						num++;
					}
				}
			}
			map[ins.x][ins.y] += num;
		}

		set<xy> tmp2;
		for (int u = 1; u <= N; u++) {
			for (int h = 1; h <= N; h++) {
				if (st.find({ u, h }) == st.end() && map[u][h] >= 2) {
					tmp2.insert({ u, h });
				}
			}
		}

		st = tmp2;

	}

	int sum = 0;
	for (int u = 1; u <= N; u++) {
		for (int h = 1; h <= N; h++) {
			sum += map[u][h];
		}
	}
	cout << sum;
}

