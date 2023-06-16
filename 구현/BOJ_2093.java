import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2093 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, num = 2;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            num += (num - 1);
        }

        System.out.println(num * num);

    }
}
