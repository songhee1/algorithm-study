import java.io.*;
import java.util.*;

/**
 * nxn 명 사람들이 대회 참가
 * 한 명이면 특별상 바로 수상하지만, 여러명이면 정사각형 4개로 나눠 구역마다 한명씩 총 4명 뽑는다
 */
public class BOJ_24460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int arr[][];
    static List<Integer> minList = new LinkedList<>();
    static int minNum;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        special(0, n-1, 0, n-1);

        Collections.sort(minList);
        if (minList.size() == 1)
            System.out.println(minList.get(0));
        else {
            for(int a : minList){
                // System.out.println(a);
            }
            System.out.println(minList.get(1));
        }
    }

    static void special(int startX, int endX, int startY, int endY) {
        if (endX - startX == 1) {
            List<Integer> list = new LinkedList<>();
            // System.out.println("start: "+start+", end:"+end);
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    list.add(arr[i][j]);
                }
            }
            Collections.sort(list);
            minNum = list.get(1);
            minList.add(minNum);

            return;
        }

        special(startX, endX / 2, startY, endY/2);
        special(endX/2+1, endX, startY, endY/2 );
        special(startX, endX / 2, endY/2+1, endY);
        special(endX/2+1, endX,endY/2+1, endY);

    }
}
