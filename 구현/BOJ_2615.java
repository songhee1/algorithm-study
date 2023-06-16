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

public class BOJ_2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[][];
    static boolean isvisited[][];
    static int distance[][];
    static int dirX[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
    static int dirY[] = { 0, 1, 0, -1, 1, -1, 1, -1 };
    static int blacknum, whitenum;
    static int lastX,lastY; 
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        arr = new int[19][19];
        isvisited = new boolean[19][19];
        distance = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 1 && isvisited[i][j] == false) {
                    distance[i][j] = 1;
                    isvisited[i][j] = true;
                    queue.add(new Pair(i, j));
                    bfs();
                }
                if (arr[i][j] == 2 && isvisited[i][j] == false) {
                    distance[i][j] = 1;
                    isvisited[i][j] = true;
                    queue.add(new Pair(i, j));
                    bfs();
                }
            }
        }

        sb.append(blacknum).append(", ").append(whitenum).append("\n");
        if (blacknum > whitenum) {
            sb.append(1).append("\n");
        } else if (blacknum == whitenum) {
            sb.append(0).append("\n");
        } else if (blacknum < whitenum) {
            sb.append(2).append("\n");
        }

        if (blacknum != whitenum) {
            sb.append(lastX-4+1).append(" ").append(lastY-4+1);
        }

        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nowX = dirX[i] + pair.x;
                int nowY = dirY[i] + pair.y;


                if (nowX < 0 || nowX >= 19 || nowY < 0 || nowY >= 19)
                    continue;

                if(isvisited[nowX][nowY] == true && arr[nowX][nowY] != arr[pair.x][pair.y]){

                }
                if (isvisited[nowX][nowY] == false && arr[nowX][nowY] == arr[pair.x][pair.y]) {
                    isvisited[nowX][nowY] = true;
                    queue.add(new Pair(nowX, nowY));
                    distance[nowX][nowY] = distance[pair.x][pair.y] + 1;

                }

                if (distance[nowX][nowY] == 5) {
                    if (arr[pair.x][pair.y] == 1) {
                        blacknum++;
                    } else if (arr[pair.x][pair.y] == 2) {
                        whitenum++;
                    }

                    lastX = nowX;
                    lastY = nowY;
                    return;
                }
            }
        }
    }
}
