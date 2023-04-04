package 브루트스포스;

import java.util.*;
import java.io.*;

/*
 * [문제를 풀었던 아이디어]
 * 1. 맨 처음 문자가 W인지 B인지에 따라서 나와야하는 배열이 달라진다.
 * 따라서, firstCh에 첫 문자를 넣어주고 열에 해당하는 j값이 2의 배수인지 아닌지에 따라
 * 어떤 문자가 나와야하는지 코드를 작성해주었다.
 * 
 * 2. 만약, 나와야하는 문자에 다른 문자가 적혀져 있으면 check배열값에 +1을 해준다.
 * 
 * 3. 마지막으로, 8*8 크기로 바꾸어주어야하는 체스판의 최솟값을 찾아야 하므로,
 * 행과 열은 0~7 인덱스로 초기화시켜놓고, 열이 주어진 체스판을 넘어간다면 행값이 체스판을 초과
 * 하지 않는 선에서 +1을 증가시키고 열도 다시 0~7 범위로 설정시켜준다.
 */
public class BOJ_1018 {
    static char arr[][];
    static int x, y;
    static char firstCh;
    static int check[][];
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] ss = s.split("\\s");

        x = Integer.parseInt(ss[0]);
        y = Integer.parseInt(ss[1]);

        arr = new char[x][y];
        check = new int[x][y];

        for (int i = 0; i < x; i++) {
            String chess = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = chess.charAt(j);
                if (i == 0 && j == 0)
                    firstCh = arr[i][j];
                else {
                    if (firstCh == 'W') {
                        if (i % 2 == 0) {
                            if (j % 2 == 0 && arr[i][j] != 'W')
                                check[i][j]++;
                            else if (j % 2 != 0 && arr[i][j] != 'B')
                                check[i][j]++;
                        } else {
                            if (j % 2 == 0 && arr[i][j] != 'B')
                                check[i][j]++;
                            else if (j % 2 != 0 && arr[i][j] != 'W')
                                check[i][j]++;
                        }
                    } else if (firstCh == 'B') {
                        if (i % 2 == 0) {
                            if (j % 2 == 0 && arr[i][j] != 'B')
                                check[i][j]++;
                            else if (j % 2 != 0 && arr[i][j] != 'W')
                                check[i][j]++;
                        } else {
                            if (j % 2 == 0 && arr[i][j] != 'W')
                                check[i][j]++;
                            else if (j % 2 != 0 && arr[i][j] != 'B')
                                check[i][j]++;
                        }
                    }
                }

            }
        }

        int rangex = 0, rangexmax = 7;
        int rangey = 0, rangeymax = 7;
        int subSum = 0;
        while (true) {

            for (int i = rangex; i < rangexmax; i++) {
                for (int j = rangey; j < rangeymax; j++) {
                    subSum += check[i][j];
                }
            }

            if (sum == 0)
                sum = subSum;
            else {
                sum = Math.min(sum, subSum);
            }

            rangey++;
            rangeymax++;
            if (rangeymax == y) {
                if (rangexmax < x - 1) {
                    rangexmax++;
                    rangex++;
                    rangey = 0;
                    rangeymax = 7;
                } else
                    break;
            }

        }
        bw.append(sum + "");

        bw.close();
        br.close();
    }
}