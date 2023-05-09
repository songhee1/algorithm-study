package 덱;

import java.io.*;
import java.util.*;

public class BOJ_5430advanced {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int testcase;
    static String p;
    static int n;
    static boolean isRight = false;
    static boolean flag = false;
    static int pointer = 0, rearPointer;

    public static void main(String[] args) throws Exception {
        testcase = Integer.parseInt(br.readLine());
        LinkedList <Integer> list = new LinkedList<>();

        while (testcase-- > 0) {
            isRight = false;

            flag = false;

            p = br.readLine();

            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            pointer = 0;
            rearPointer = list.size();

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isRight = !isRight;
                    if(isRight == false){
                        int tmp = pointer;
                        pointer = rearPointer + 1;
                        rearPointer = tmp + 1;

                    }else{
                        int tmp = pointer;
                        pointer = rearPointer -1;
                        rearPointer = tmp -1;
                    }

                } else if (p.charAt(i) == 'D') {
                    if (pointer == rearPointer) {
                        sb.append("error").append("\n");
                        flag = true;
                        break;
                    }else{
                        if(isRight == false){
                            pointer ++;
                            list.poll();
                        }else{
                            pointer --;
                            list.pollLast();
                        }
                    }
                    
                }
            }
            if (flag == false) {
                sb.append("[");
                if (list.size() > 0) {
                    if (isRight == false) {
                        sb.append(list.poll());
                        while (!list.isEmpty()) {
                            sb.append(",").append(list.poll());
                        }
                    } else {
                        sb.append(list.pollLast());
                        while (!list.isEmpty()) {
                            sb.append(",").append(list.pollLast());
                        }
                    }
                }

                sb.append("]").append("\n");
            }
        }

        System.out.print(sb);
        br.close();

    }

}
