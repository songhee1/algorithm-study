import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int N;
    static int map[][];
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            for (int[] d : dist)Arrays.fill(d, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            dist[0][0] = 0;
            bfs();
            System.out.printf("#%d %d\n", tc, dist[N - 1][N - 1]);

        }
    }

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    private static void bfs() {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] { 0, 0, 0 });
        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)continue;

                int nd = now[2] + map[nx][ny];
                if (dist[nx][ny] > nd) { 
                    dist[nx][ny] = nd;
                    Q.offer(new int[] { nx, ny, nd });
                }
            }
        }

    }

}
