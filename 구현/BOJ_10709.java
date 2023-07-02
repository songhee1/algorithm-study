package 구현;

import java.io.*;
import java.util.*;

/**
 * 남북방향이 h킬로미터, 동서방향 w킬로미터
 * 구름이 몇 분 뒤 하늘에 구름이 오는지 예측
 * 구름은 1분마다 1킬로미터씩 이동하게 된다.
 * 구름이 떠있는 경우 영어 소문자 'c', 없는 경우 '.'가 주어진다.
 */
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_10709 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int h, w;
    static char arr[][];
    static int dist[][];
    static StringTokenizer st;
    static Queue<Pair> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new char[h][w];
        dist = new int[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 'c' && dist[i][j] == -1) {
                    dist[i][j] = 0;
                    queue.add(new Pair(i, j));
                    bfs();
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            if (i == h - 1)
                continue;
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            int nx = now.x;
            int ny = now.y + 1;

            if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                continue;
            if (dist[nx][ny] == -1 && arr[nx][ny] == '.') {
                dist[nx][ny] = dist[now.x][now.y] + 1;
                queue.add(new Pair(nx, ny));
            }

            if (dist[nx][ny] == -1 && arr[nx][ny] == 'c')
                continue;

        }
    }
}
