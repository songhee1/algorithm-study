package 브루트스포스;

import java.util.*;
import java.io.*;

public class BOJ_14888 {
    static int n;
    static int arr[];
    static boolean visited[];
    static String calcCh[];
    static String answer[];
    static int maxN, minN;
    static Vector<Integer> v = new Vector<>();
    static Vector<String> calc = new Vector<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        calcCh = new String[10];
        //n: 2~11범위이므로 연산자는 최대 10개 까지 필요하므로 크기는 10으로 선언
        answer = new String[n - 1];
        //조합을 만들려는 연산자들을 집어넣는 배열 생성(크기는 n-1)
        visited = new boolean[10];
        //방문여부를 확인하는 배열

        String[] s = br.readLine().split("\\s");
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);

        String[] chs = br.readLine().split("\\s");
        //연산자들을 차례대로 확인하면서 chs값이 0이 아닌 연산자가 있다면, 해당 값만큼 반복문을 돌려 벡터에 추가한다.
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == "0")
                continue;
            if (i == 0)   for (int j = 0; j < Integer.parseInt(chs[i]); j++)   calc.add("+");
            else if (i == 1) for (int j = 0; j < Integer.parseInt(chs[i]); j++)    calc.add("-");   
            else if (i == 2)   for (int j = 0; j < Integer.parseInt(chs[i]); j++)  calc.add("*");
            else if (i == 3)   for (int j = 0; j < Integer.parseInt(chs[i]); j++)   calc.add("/");
        }

        //완성된 벡터들을 순서를 바꿔가며 최대값과 최솟값을 찾는다.
        BTF(0);

        for (int i = 0; i < v.size(); i++) {
            if (i == 0) {
                minN = v.get(0);
                maxN = v.get(0);
            } else {
                maxN = Math.max(maxN, v.get(i));
                minN = Math.min(minN, v.get(i));
            }
        }
        bw.append(maxN + "\n");
        bw.append(minN + "\n");
        bw.close();
        br.close();
    }

    static void BTF(int count) {
        if (count == n - 1) {
            int initial = arr[0];
            int index = 0;
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == "+")
                    initial += arr[++index];
                else if (answer[i] == "-")
                    initial -= arr[++index];
                else if (answer[i] == "*")
                    initial *= arr[++index];
                else if (answer[i] == "/") {
                    if (initial < 0) {
                        initial *= (-1);
                        initial /= arr[++index];
                        initial *= (-1);
                    } else {
                        initial /= arr[++index];
                    }
                }
            }
            v.add(initial);
            return;
        }

        for (int i = 0; i < calc.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[count] = calc.get(i);
                BTF(count + 1);
                visited[i] = false;
            }

        }
    }
}
