import java.io.*;
import java.util.*;
public class BOJ_2565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int arr[][];
    static int dir[];
    static int n, maxnum;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][2];
        dir = new int[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int []o1, int []o2){
                return o1[0]-o2[0];
            }
        });

        for(int i=1;i<=n;i++){
            dir[i]=1;
            for(int j=1;j<i;j++){
                if(arr[i][1]>arr[j][1]){
                    dir[i] = Max(dir[i], dir[j]+1);
                }
            }
        }

        int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, dir[i]);
		}

        System.out.print( n - max);
        br.close();
    }
    static int Max(int a, int b){
        return a>b ? a : b;
    }
}
