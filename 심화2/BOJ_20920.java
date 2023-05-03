package 심화2;

import java.io.*;
import java.util.*;

import javax.management.ValueExp;

public class BOJ_20920 {
    /*
     * 단어장 생성 우선순위
     * 1. 자주 나오는 단어일수록 앞에 배치
     * 2. 해당 단어 길이가 길수록 앞에 배치
     * 3. 알파벳 사전순으로 앞에 있는 단어일수록 앞에 배치
     * 
     * 길이가 M이상인 단어들만 단어장 생성
     * 
     * 입력값
     * 단어개수N, 단어길이 M(1<=N<=100,000, 1<=M<=10)
     * 외울단어들(소문자)
     */
    static int n, m;
    static int frequency, maxFr, idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<Integer, String> mappedByFr = new HashMap<Integer, String>();
        Map<String, Integer> mappedByName = new HashMap<String, Integer>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() >= m) {
                if (mappedByName.containsKey(s)) {
                    frequency = mappedByName.get(s);
                    mappedByName.replace(s, mappedByName.get(s) + 1);
                    mappedByFr.replace(frequency + 1, s);
                    maxFr = Math.max(frequency, maxFr);
                    if (frequencyMap.containsKey(frequency + 1)) {
                        frequencyMap.replace(frequency + 1, frequencyMap.get(frequency + 1) + 1);
                    } else {
                        frequencyMap.put(frequency + 1, 1);
                    }
                } else {
                    mappedByName.put(s, 1);
                    mappedByFr.put(1, s);
                    frequencyMap.put(1, 1);
                    frequency = 0;
                    if (frequencyMap.containsKey(frequency + 1)) {
                        frequencyMap.replace(frequency + 1, frequencyMap.get(frequency + 1) + 1);
                    } else {
                        frequencyMap.put(frequency + 1, 1);
                    }
                }
            }
        }


        // 규칙1번
        for (int i = 0; i < mappedByFr.size(); i++) {
            if(maxFr==0){
                break;
            }
            String[] words=new String[maxFr];
            if (frequencyMap.get(maxFr) > 1) {
                for (String valueName : mappedByName.keySet()) {
                    if (mappedByName.get(valueName) == maxFr) {
                        words[idx] = valueName;
                        idx++;
                    }
                }

                if(words.length>1){
                Arrays.sort(words, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() > o2.length()) {
                            return -1;
                        } else
                            return o1.compareTo(o2);
                    }
                });
            }

                for(int j=0;j<words.length;j++) sb.append(words[j]).append("\n"); 

            } else {
                sb.append(mappedByFr.get(maxFr)).append("\n");
            }

            maxFr--;
        }

        System.out.print(sb);
        br.close();

    }
}
