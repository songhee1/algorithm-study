package 정렬;

import java.util.*;
import java.io.*;

public class BO_18870 {
    static int n;
    static long arr[], originalArr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map=new HashMap<>();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        arr=new long[n];
        originalArr=new long[n];

        for(int i=0;i<n;i++) {
            long r=Integer.parseInt(st.nextToken());
            arr[i]=r;
            originalArr[i]=r;
        }

        Arrays.sort(arr);
        
        int count=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])) continue;
            map.put(arr[i],count);
            count++;
        }

        for(int i=0;i<n;i++){
            sb.append(map.get(originalArr[i])).append(' ');
        }


        System.out.println(sb);
        br.close();

    }
}