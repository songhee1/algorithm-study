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

public class BOJ_1926 {
    static int n, m;
    static int graph[][];
    static boolean visited[][];
    static int nums[];
    static int num, nSum;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int nx, ny;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sgrim = br.readLine();
        String[] grim = sgrim.split("\\s");
        n = Integer.parseInt(grim[0]);
        m = Integer.parseInt(grim[1]);
        graph = new int[n][m];
        visited = new boolean[n][m];
        Vector<Integer> v = new Vector<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] ss = s.split("\\s");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(ss[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    nSum++;
                    q.add(new Pair(i, j));
                    num = 0;
                    v.add(BFS());
                }
            }
        }

        bw.append(nSum + "\n");
        if(v.size()>0){
            Collections.sort(v, new Comp());
            bw.append(v.firstElement() + "\n");
        }else{
            bw.append(0+"\n");
        }
        
        bw.close();
        br.close();

    }

    static int BFS() {
        while (!q.isEmpty()) {
            num++;
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                nx = cur.x + dx[dir];
                ny = cur.y + dy[dir];
                if (RangeCorrect() && visited[nx][ny] == false && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return num;

    }

    static boolean RangeCorrect() {
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
            return false;
        return true;
    }
}
