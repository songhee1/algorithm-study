package 스택;

import java.io.*;
import java.util.*;

public class BOJ_4949 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char arr[];
    static int pointer = -1;
    static String s;

    public static void main(String[] args) throws Exception {

        while (true) {
            pointer = 0;
            s = br.readLine();
            if (s.equals("."))
                break;

            arr = new char[s.length()];

            checkStatement();

        }

        System.out.print(sb);
        br.close();
    }

    static void checkStatement() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                arr[pointer] = c;
                pointer++;
            } else if (pointer != 0) {
                if (c == ')' && arr[pointer-1] == '(') {
                    arr[pointer-1]=0;
                    pointer -= 1;
                } else if (c == ']' && arr[pointer-1] == '[') {
                    arr[pointer-1]=0;
                    pointer -= 1;
                } else if (c == ')' && arr[pointer-1] != '(') {
                    sb.append("no").append("\n");
                    return;
                } else if (c == ']' && arr[pointer-1] != '[') {
                    sb.append("no").append("\n");
                    return;
                }

            }else if(c==')'|| c==']'){
                sb.append("no").append("\n");
                return;
            }

        }
        sb.append("yes").append("\n");
        return;
    }
}
