#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int N, M, K;
int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };


struct fireball {
	int r;
	int c;
	int m;
	int s;
	int d;
};

vector<fireball> fireballs;
vector<fireball> map[51][51];
void move() {
	for (int i = 0; i < fireballs.size(); i++) {
		fireball ball = fireballs[i];
		int x = ball.r;
		int y = ball.c;
		int s = ball.s;
		int d = ball.d;
		for (int j = 0; j < s; j++) {
			x += dx[j];
			y += dy[j];
			if (x < 1) {
				x = N;
			}
			else if (x > N) {
				x = 0;
			}

			if (y < 1) {
				y = N;
			}
			else if (y > N) {
				y = 0;
			}
		}

		map[x][y].push_back({ x, y, ball.m, s, d });
	}
}
void sum() {
	vector<fireball> tmp;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j].size() == 1) {
				fireball ball = map[i][j][0];
				tmp.push_back({ i, j, ball.m, ball.s, ball.d });
			}
			else if (map[i][j].size() >= 2) {
				int sumM = 0;
				int sumS = 0;
				bool odd = true; // 홀수
				bool even = true; //짝수
				for (int k = 0; k < map[i][j].size(); k++) {
					fireball ball = map[i][j][k];
					sumM += ball.m;
					sumS += ball.s;

					if (ball.d % 2 == 0) {
						odd = false;
					}
					else if (ball.d % 2 == 1) {
						even = false;
					}
				}

				int mm = sumM / 5;
				int ss = sumS / map[i][j].size();
				if (mm == 0) {
					continue;
				}
				if ((odd == false && even == true) || (odd == true && even == false)) {
					tmp.push_back({ i, j, mm, ss, 0 });
					tmp.push_back({ i, j, mm, ss, 2 });
					tmp.push_back({ i, j, mm, ss, 4 });
					tmp.push_back({ i, j, mm, ss, 6 });
				}
				else {
					tmp.push_back({ i, j, mm, ss, 1 });
					tmp.push_back({ i, j, mm, ss, 3 });
					tmp.push_back({ i, j, mm, ss, 5 });
					tmp.push_back({ i, j, mm, ss, 7 });
				}
			}
		}
	}

	fireballs = tmp;
}
int sumMM() {
	int result = 0;
	for (int i = 0; i < fireballs.size(); i++) {
		result += fireballs[i].m;
	}
	return result;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> N >> M >> K;
	
	int r, c, m, s, d;
	for (int i = 0; i < M; i++) {
		cin >> r >> c >> m >> s >> d;
		
		fireballs.push_back({ r, c, m, s, d });
	}

	for (int i = 0; i < K; i++) {
		//이동
		move();
		//합치기
		sum();
	}
	
	cout << sumMM();
}

