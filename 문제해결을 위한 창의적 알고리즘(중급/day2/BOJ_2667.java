package day2;

import java.io.*;
import java.util.*;

public class BOJ_2667 {
    static int N;
    static int arr[][];
    static boolean visited[][];
    static int nowX, nowY;
    static int count, num;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    count = 0;
                    num++;
                    visited[i][j] = true;
                    DFS(i, j);
                    list.add(count);
                }
            }
        }

        bw.append(num + "\n");
        Collections.sort(list);

        for (int a : list) {
            bw.append(a + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void DFS(int i, int j) {
        count++;
        for (int dir = 0; dir < 4; dir++) {
            nowX = i + dx[dir];
            nowY = j + dy[dir];
            if (CheckRange()==true && visited[nowX][nowY] == false && arr[nowX][nowY] == 1) {
                visited[nowX][nowY] = true;
                DFS(nowX, nowY);
            }
        }
    }

    static boolean CheckRange() {
        if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= N) {
            return false;
        }
        return true;
    }
}
