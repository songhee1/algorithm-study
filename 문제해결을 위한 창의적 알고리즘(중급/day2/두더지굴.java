package day2;

import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Comp implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        return o1>o2?-1:(o1==o2?0:1);
    }
}

public class 두더지굴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] graph = new int[30][30];
        int n = Integer.parseInt(br.readLine());
        String ss;
        String s[];

        Queue<Pair> queue = new LinkedList<>();

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            ss = br.readLine();
            s = (ss.split("\\s"));
            for (int j = 0; j < n; j++)
                graph[i][j] = Integer.parseInt(s[j]);
        }
        int num=0;
        Vector<Integer> gool=new Vector<>();
        int k=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && dist[i][j] == 0) {
                    Pair pair = new Pair(i, j);
                    queue.add(pair);
                    dist[i][j] = 1;

                    num++;
                    int blockNum=1;
                    while (!queue.isEmpty()) {

                        Pair cur =queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;
                            if (graph[nx][ny] == 0)
                                continue;
                            if (dist[nx][ny] > 0)
                                continue;
                            dist[nx][ny] += ++blockNum;                      
                            Pair newPair = new Pair(nx, ny);
                            queue.add(newPair);
                        }
                    }
                    gool.add(blockNum);
                    k++;

                }

            }
        }

        System.out.println(num);
        Collections.sort(gool, new Comp());
        for(int a:gool){
            System.out.println(a);
        }

    }
}
