package 다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class BOJ_9251 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String string_1, string_2;
    static char arr1[], arr2[];
    static int LCS[][];

    public static void main(String[] args) throws Exception {
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        LCS = new int[arr1.length+1][arr2.length+1];

        for(int i = 1;i<=arr1.length;i++){
            for(int j=1;j<=arr2.length;j++){
                if(arr1[i-1] == arr2[j-1]){
                    LCS[i][j] = LCS[i-1][j-1]+1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        System.out.print(LCS[arr1.length][arr2.length]);
        br.close();
    }
}
