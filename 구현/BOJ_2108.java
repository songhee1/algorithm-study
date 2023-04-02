package 구현;

import java.io.*;
import java.util.*;

class Compt implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
    }
}

public class BOJ_2108 {
    static int n;
    static int arr[];
    static int howmanyvisit[];
    static float sum;
    static int maxnum, maxIndex;
    static int same;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Vector<Integer> v = new Vector<>();

        arr = new int[n];
        howmanyvisit = new int[8001];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = Integer.parseInt(s);
            sum += arr[i];
            if (arr[i] < 0) {
                howmanyvisit[4000 + (arr[i] * (-1))]++;
                if (maxnum < howmanyvisit[4000 + (arr[i] * (-1))]) {
                    maxIndex = arr[i];
                    maxnum = howmanyvisit[4000 + arr[i] * (-1)];
                    v.clear();
                    v.add(maxIndex);
                } else if (maxnum == howmanyvisit[4000 + (arr[i] * (-1))]) {
                    v.add(arr[i]);
                }
            } else {
                howmanyvisit[arr[i]]++;
                if (maxnum < howmanyvisit[arr[i]]) {
                    maxIndex = arr[i];
                    maxnum = howmanyvisit[arr[i]];
                    v.clear();
                    v.add(maxIndex);
                } else if (maxnum == howmanyvisit[arr[i]]) {
                    v.add(arr[i]);
                }
            }
        }

        Arrays.sort(arr);
        Collections.sort(v);
        if (v.size() > 2) {
            maxIndex = v.get(1);
        } else if (v.size() == 2) {
            maxIndex = v.lastElement();
        } else {
            maxIndex = v.get(0);
        }

        bw.append(Math.round(sum / n) + "\n");
        bw.append(arr[(n - 1) / 2] + "\n");
        bw.append(maxIndex + "\n");
        bw.append(arr[n - 1] - arr[0] + "");
        bw.close();
        br.close();
    }
}