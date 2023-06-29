import java.io.*;
import java.util.*;
public class BOJ_11729{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, count;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        hanoi(n, 1,2,3);
        System.out.println(count);
        System.out.println(sb);
    }
    private static void hanoi(int n, int start, int mid, int to){
        if(n == 1){
            count++;
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1, start, to, mid);
        hanoi(1, start, mid, to);
        hanoi(n-1, mid, start, to);
    }
}
