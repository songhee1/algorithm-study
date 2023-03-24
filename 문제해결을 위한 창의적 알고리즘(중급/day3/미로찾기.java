package day3;

import java.io.*;
import java.util.*;

public class 미로찾기 {

    static int h, w;
    static int dist[][];
    static char array[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int nowX, nowY;
    static int minShortDistance;
    static boolean ishere;

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
                if (array[i][j] == 'S') {
                    BFS(i, j);
                }
            }
        }

        bw.append(minShortDistance + "\n");
        br.close();
        bw.close();
    }

    static void BFS(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                nowX = cur.x + dx[dir];
                nowY = cur.x + dx[dir];
                System.out.print(cur.x+", "+cur.y+": ");
                if (CheckRange() == true && (array[nowX][nowY] == '.'|| array[nowX][nowY]=='G') && dist[nowX][nowY] == 0) {
                    dist[nowX][nowY] = dist[cur.x][cur.y] + 1;
                    queue.add(new Pair(nowX, nowY));
                    System.out.println(nowX+","+nowY);
                    System.out.println();
                    if(array[nowX][nowY]=='G') {
                        minShortDistance=dist[nowX][nowY];
                        return;
                    }
                }
            }
        }
        minShortDistance=-1;
        return;
    }

    static boolean CheckRange() {
        if (nowX < 0 || nowX >= h || nowY < 0 || nowY >= w)
            return false;
        return true;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
