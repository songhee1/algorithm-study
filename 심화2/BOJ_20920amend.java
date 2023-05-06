package 심화2;

import java.io.*;
import java.util.*;

public class BOJ_20920amend {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    /*
     * String arr[] : 입력 문자열을 저장하는 배열
     * Set <String> s : 길이가 m 이상인 문자열을 저장하는 세트
     * int frequency[] : arr 문자열 각각에 대해 s의 요소 빈도수 저장하는 배열
     * maxFrequency : 가장 큰 빈도수 저장 변수
     * Vector <String> v : 특정 빈도수에 해당하는 문자열 저장하는 벡터
     */
    static String arr[];
    static int frequency[];
    static int maxFrequency;

    public static void main(String[] args) throws Exception {
        Vector<String> s = new Vector<>();
        Vector<String> v = new Vector<>();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n];
        frequency = new int[s.size()];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if (arr[i].length() >= m)
                s.add(arr[i]);
        }

        for (int i = 0; i < s.size(); i++) {
            for (String a : arr) {
                if (s.contains(a)) {
                    frequency[i]++;
                    maxFrequency = Math.max(maxFrequency, frequency[i]);
                }
            }
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == maxFrequency) {
                v.add(s.get(i));
            }
        }

        if (v.size() == 1)
            sb.append(s.get(0)).append("\n");
        else {
            Collections.sort(v, new Comp());
        }

        v.clear();


    }

    class Comp implements Comparator<String>{
        public int compare(String o1, String o2){ //compara 메소드를 구현
        if(o1.length() == o2.length()){
            return o1.compareTo(o2);
        }else if(o1.length()<o2.length()) return -1;
        else{
            return 1;
        }
        }
}
