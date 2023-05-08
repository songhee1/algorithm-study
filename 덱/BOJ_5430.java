package 덱;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int testcase, n;
    static String p;
    static int tmp;
    static boolean flag = true;

    /*
     * 수행할 함수(p)가 R이면 뒤집어야 한다
     * - 1회 수행시
     * 인덱스 0부터 Math.sqrt(list.size()) 까지 수행한다.
     * tmp = list.get(i)
     * list.add(i, list.get((n-1)-i))
     * list.add((n-1)-i, tmp)
     * 
     * 수행할 함수가 D라면 맨 앞에 있는 것을 제거한다.
     * - 만약 리스트가 비어있다면 error 출력
     * list.poll()
     */

    static int arr[], pointer, frontPointer = 0;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < testcase; i++) {
            pointer=0;
            frontPointer=0;
            list.clear();
            flag = false;
            p = br.readLine();
            n = Integer.parseInt(br.readLine());

            arr = new int[n];

            String a = br.readLine();
            if (a.length() > 2) {
                a = a.substring(1, a.length() - 1);
                String b[] = a.split(",");

                for (int j = 0; j < b.length; j++) {
                    arr[pointer] = Integer.parseInt(b[j]);
                    pointer++;
                }
            }else if(a.length() == 1){
                arr[0]=Integer.parseInt(a.substring(0, 1));
                pointer++;
            }

            for (int j = 0; j < p.length(); j++) {
                System.out.println(p.length());
                if (p.charAt(j) == 'R') {
                    for (int k = 0; k < (int)Math.sqrt(pointer - frontPointer); k++) {
                        tmp = arr[k];
                        arr[k] = arr[pointer - 1 - k];
                        System.out.println(k+", "+(pointer - 1 - k)+","+pointer+","+frontPointer );
                        arr[pointer - 1 - k] = tmp;
                    }

                } else if (p.charAt(j) == 'D') {
                    if (pointer == frontPointer) {
                        sb.append("error").append("\n");
                        flag = true;
                        break;
                    } else {
                        frontPointer++;
                    }

                }
            }

            if (flag == false) {
                sb.append("[");
                for (int b = frontPointer; b <= pointer - 2; b++) {
                    sb.append(arr[b]).append(",");
                }
                if (pointer != 0 && frontPointer!=pointer) {
                    sb.append(arr[pointer - 1]);
                }
                sb.append("]").append("\n");
            } else {
                continue;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
