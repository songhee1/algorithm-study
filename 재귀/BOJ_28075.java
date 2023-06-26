import java.io.*;
import java.util.*;

/**
 * 하루에 한 가지 임무만 수행할 수 있고 하루에 한 장소에서만 임무 수행 가능
 * 반드시 하루에 최소 하나의 임무 수행
 * 전날 임무를 수행한 곳과 같은 장소 선택시 그 날은 원래 절반에 해당하는 진척도만 얻게 된다
 * 
 * 각 임무수행시 임무완수를 위한 진척도를 얻게된다
 * 민겸이 기여도 = 얻은 진척도의 합이다
 * 진척도가 주어질때 민겸이가 m이상의 기역도를 얻을수있는 임무수행방법은 몇가지인지 구하여라
 * 
 * 
 * 입력
 * 임무수행 총 일수 n, 민겸이가 얻고싶은 최소 기여도m
 * 정보수집임무 진척도(수족관,시청,학교)
 * 감시임무 진척도(수족관,시청,학교)
 * 
 * 출력
 * 기여도 m이상 얻을수있는 임무수행방법 몇가지인지 출력
 */
public class BOJ_28075 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, count;
    static int arr[][];
    static boolean wa, of, sc;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0,-1);

        System.out.println(count);
    }

    static void dfs(int sum, int num, int place) {
        if (num == n) {
            if (sum >= m) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            for(int j=0;j<3;j++){
                if(place == j){
                    dfs(sum+(arr[i][j]/2), num+1, j);
                }else{
                    dfs(sum+arr[i][j], num+1, j);
                }
            }
        }
    }
}