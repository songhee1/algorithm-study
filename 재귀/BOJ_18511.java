import java.io.*;
import java.util.*;

public class BOJ_18511 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, sidx=-1;
    static int arr[];
    static String standard;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findNum(0);
    }

    static void findNum(int num) {
        sidx++;
        System.out.println( s);
        if (s.length() == standard.length()) {
            return;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (flag == false) {
                if (arr[i] < standard.charAt(sidx) - '0') {
                    flag = true;
                    findNum(s + String.valueOf(arr[i]));
                    break;
                } else if (arr[i] == standard.charAt(sidx) - '0') {
                    findNum(s + String.valueOf(arr[i]));
                    break;
                }else{
                    for(int j=k-1;j>=0;j--){
                        if(arr[j]<s.charAt(0)){
                            sidx=0;
                            findNum(s+String.valueOf(arr[j]));
                            break;
                        }
                    }
                }
            } else {
                System.out.println("true" + ", " + i);
                findNum(s + String.valueOf(arr[i]));
                break;
            }
        }
    }
}
