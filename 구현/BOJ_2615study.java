import java.io.*;
import java.util.StringTokenizer;

//  @author : blog.naver.com/kerochuu 
//  @date : 2020. 2. 1.                   
public class BOJ_2615study {

	static int[][] map = new int[21][21];
	static int[][][] memo = new int[21][21][4];
	static int[] dx = { 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		System.out.println(findFive());
	}

	private static String findFive() {
		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
							return map[i][j] + "\n" + i + " " + j + "\n";
						}
					}
				}
			}
		}
		return "0";
	}

	private static int calc(int x, int y, int dir, int color) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (map[nx][ny] == color) {
			memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
            System.out.println(nx+", "+ny+", "+memo[nx][ny][dir]);
            return memo[nx][ny][dir];
		}
		return 1;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}