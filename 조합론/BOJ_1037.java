import java.io.*;
import java.util.*;
public class BOJ_1037 {
    static int n;
    static int arr[];
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());

        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.print(arr[0]*arr[n-1]);
        br.close();
    }
}
