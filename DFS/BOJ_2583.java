package DFS;

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

public class BOJ_2583 {
    static int arr[][];
    static boolean visit[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int m, n, k, nx, ny, count,answer; // 세로, 가로, k개 사각형
    static int dist[][];
    static Queue<Pair> queue = new LinkedList<>();
    static int dirX[] = { 1, 0, -1, 0 };
    static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()) ;
        n = Integer.parseInt(st.nextToken()) ;
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];

        ArrayList<Integer> list = new ArrayList<>();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            for (int i = a2; i < b2; i++) {
                for (int j = a1; j < b1; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (arr[i][j] == 0 ) {
                    answer=0;
                   bfs(i,j);
                   list.add(answer); 
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(Integer a: list){
            System.out.print(a+" ");
        }
      
    }

    static void bfs(int x, int y) {
        answer++;
        arr[x][y]=1;
       
        for (int dir = 0; dir < 4; dir++) {
            nx = x + dirX[dir];
            ny = y + dirY[dir];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (arr[nx][ny]==0) {
                bfs(nx,ny);
            }
        }

    }
}
