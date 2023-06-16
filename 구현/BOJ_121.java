import java.io.*;
import java.util.*;

public class BOJ_121 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int pontX, pontY;
    static int mapX, mapY;
    static int arr[][]; // 물고기 가치 배열
    static int maxValue;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        pontX = Integer.parseInt(st.nextToken());
        pontY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        mapX = Integer.parseInt(st.nextToken());
        mapY = Integer.parseInt(st.nextToken());

        arr = new int[pontX][pontY];

        for (int i = 0; i < pontX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pontY; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < pontX - mapX + 1; i++) {
            for (int j = 0; j < pontY - mapY + 1; j++) {
                for (int k = i; k < i + mapX; k++) {
                    int sum = 0;
                    for (int h = j; h < j + mapY; h++) {
                        sum += arr[k][h];
                    }
                    if (maxValue < sum) {
                        maxValue = sum;
                    }
                }
            }
        }

        System.out.println(maxValue);

    }
}
