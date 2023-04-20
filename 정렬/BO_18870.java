package 정렬;

import java.util.*;
import java.io.*;

public class BO_18870 {
    static int n;
    static int arr[][];
    static Vector<Integer> v = new Vector<>();
    static boolean hasCameOut;

    /*
     * Counting sorting + BufferedReader + StringBuilder + StringTokenizer + Vector(요소값 존재하는지 확인)
     * 시간: 시간초과
     * 
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = 0;
        }

        for (int i = 0; i < n; i++) {
            v.clear();
            for (int j = 0; j < n; j++) {
                if (arr[i][0] == arr[j][0])
                    continue;
                if (arr[i][0] > arr[j][0]) {

                    for (int k = 0; k < v.size(); k++) {
                        if (v.get(k) == arr[j][0]) {
                            hasCameOut = true;
                            break;
                        }
                    }
                    if (hasCameOut){
                        hasCameOut=false;
                        continue;
                       
                    }

                    v.add(arr[j][0]);
                    arr[i][1]++;
                }

            }
        }

        for (int i = 0; i < n; i++)
            sb.append(arr[i][1]).append(' ');

        System.out.println(sb);
        br.close();

    }
}