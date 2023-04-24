package 집합과맵;

import java.io.*;
import java.util.*;

public class BOJ_11478 {
    /*
     * 부분 문자열로 나누는 substring(startindex, endindex)
     * 입력 문자열 길이만큼 반복, 부분 문자열 길이까지 자른다
     * 시간 932ms
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String newline = s.substring(i, j);
                if (!set.contains(newline))
                    set.add(newline);
            }
        }

        sb.append(set.size());
        System.out.print(sb);
        br.close();
    }

}
