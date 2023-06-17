import java.io.*;
import java.util.*;

public class BOJ_2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[][], memo[][][];
    static int dirX[] = { -1, 0, 1, 1 };
    static int dirY[] = { 1, 1, 1, 0 };

    /*
     * 오목의 상태를 저장하는 배열 arr[][]와 오목이 방향에 따라서 같은 색을 가진 배열일 경우 1을 증가시키는 배열 memo[][]를 지정합니다.
     * 
     * 세로 1열부터 19열까지/ 가로 1열부터 19열까지 반복하며 위->아래(오목이 일렬로 만들어진 경우), 아래 좌-> 위 우(오른쪽 대각선 위를 향하는 오목일 경우),
     * 위 좌->아래 우(오른쪽 대각선 아래를 향하는 오목일 경우), 좌->우(오목이 가로로 일렬인 경우) 이 네가지 방향을 dirX, dirY 배열에 작성합니다.
     * 
     * 가장 먼저 오목이 안그려진 바둑알을 찾아야하므로 memo[][]=0인지 확인 & 총 5개인지 확인 합니다. calc함수
     * 
     * calc함수는 dir, 색 파라미터를 받아서 동일한 색과 방향인지 확인해서 계속해서 1을 더하고 5가 되면 리턴됩니다.  
     */

    public static void main(String[] args) throws Exception {
        arr = new int[25][25];
        memo = new int[25][25][4];

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
         for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (arr[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {

                        if (memo[i][j][dir] == 0 && calc(i, j, dir, arr[i][j]) == 5) {
                            sb.append(arr[i][j]).append("\n").append(i).append( " ").append( j).append("\n");
                        }
                    }
                }
            }
        }
        System.out.println(sb);
        

    }


    private static int calc(int i, int j, int dir, int color) {
        int nx = i + dirX[dir];
        int ny = j + dirY[dir];
        
        if (arr[nx][ny] == color) {
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
        }
        return 1;
    }
}
