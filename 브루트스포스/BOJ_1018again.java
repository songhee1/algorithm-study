package 브루트스포스;

import java.io.*;
import java.util.*;

/**
 * 검은색과 흰색이 번갈아 칠해져야 한다.
 * 변을 공유하는 두 사각형은 다른 색으로 칠해져 있어야 한다.
 * 체스판 칠하는 경우는 두가지, 맨 위쪽 칸이 흰색, 다른 하나는 검은색인 경우
 * 
 */
public class BOJ_1018again {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static char arr[][], copy[][];
    static int minNum = Integer.MAX_VALUE;
    static StringTokenizer st;
    static char firstChar;
    static String wb[] = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
    };
    static String bw[] = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                find(i, i + 7, j, j + 7);
            }
        }

        System.out.println(minNum);
    }

    static void find(int startX, int endX, int startY, int endY) {
        char X, Y;
        // System.out.print("startX:" + startX + ", endX:" + endX + "/ startY:" + startY
        // + ", endY:" + endY);
        boolean bwboolean = false;
        boolean wbboolean = false;
        if (arr[startX][startY] == 'B') {
            X = 'B';
            Y = 'W';
            bwboolean = true;
        } else {
            X = 'W';
            Y = 'B';
            wbboolean = true;
        }

        int count = 0;

        if (bwboolean == true) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i + startX][j + startY] != bw[i].charAt(j)) {
                        count++;
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[i + startX][j + startY] != wb[i].charAt(j)) {
                        count++;
                    }
                }
            }
        }

        // System.out.println("/// count : " + count);
        minNum = Math.min(minNum, count);
    }
}

// if (i == startX && j == startY)
// continue;

// if (i % 2 == 0 && j % 2 == 0) {
// if (copy[i][j] != X) {
// count++;
// }
// } else if (i % 2 == 1 && j % 2 == 1) {
// if (copy[i][j] != X) {
// count++;
// }
// } else if (i % 2 == 0 && j % 2 == 1) {
// if (copy[i][j] != Y) {
// count++;
// }
// } else if (i % 2 == 1 && j % 2 == 0) {
// if (copy[i][j] != Y) {
// count++;
// }
// }