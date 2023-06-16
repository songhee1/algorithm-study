import java.io.*;
import java.util.*;

public class BOJ_2622 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count, n;
    static boolean visited[][][];
    static StringBuilder sb = new StringBuilder();

    /*
     * 비선형구조의 알고리즘
     * 
     * 재귀로 +1을해서 들어가기때문에 1000이상의 큰 n에 대해서는 시간초과 or 메모리초과가 난다.
     * 따라서 다른 방법 생각해야한다.
     * 
     */

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n][n];
        
        findTriangleFlower(1,1,1);

        System.out.println(count);
    }

    static void findTriangleFlower(int a, int b, int c){
        if(a+b>c && a<=b && b<=c && visited[a][b][c] == false && a+b+c == n){
            count++;
            visited[a][b][c] = true;
            System.out.println(a+", "+b+", "+c);
            return;
        }

        if(a+b+c > n){
            return;
        }

        if(a> n/2 || b>n/2){
            return;
        }

        findTriangleFlower(a+1, b, c);
        findTriangleFlower(a, b+1, c);
        findTriangleFlower(a, b, c+1);
        
    }
}
