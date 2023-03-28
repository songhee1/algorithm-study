
import java.io.*;
import java.util.*;
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로찾기 {

    static int h, w;
    static int dist[][];
    static char array[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int nowX, nowY;
    static int minShortDistance=-1;
    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] sAry = s.split("\\s");

        h = Integer.parseInt(sAry[0]);
        w = Integer.parseInt(sAry[1]);

        dist = new int[h][w];
        array = new char[h][w];

        for (int i = 0; i < h; i++) {
            String string = br.readLine();
            for (int j = 0; j < w; j++) {
                array[i][j] = string.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (array[i][j] == 'S' && dist[i][j]==0) {
                    bw.append(BFS(i, j)+"\n");
                }
            }
        }

        br.close();
        bw.close();
    }

    static int BFS(int i, int j) {
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                nowX = cur.x + dx[dir];
                nowY = cur.y + dy[dir];
                if (CheckRange() == true && (array[nowX][nowY] == '.'|| array[nowX][nowY]=='G') && dist[nowX][nowY] == 0) {
                    dist[nowX][nowY] = dist[cur.x][cur.y] + 1;
                    q.add(new Pair(nowX, nowY));
                    if(array[nowX][nowY]=='G') {
                        return dist[nowX][nowY];
                    }
                }
            }
        }
        return -1;
    }

    static boolean CheckRange() {
        if (nowX < 0 || nowX >= h || nowY < 0 || nowY >= w)
            return false;
        return true;
    }
}

