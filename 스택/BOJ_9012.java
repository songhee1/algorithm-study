package 스택;

import java.io.*;
import java.util.*;

public class BOJ_9012 {
    static int n;
    static char vpsChar;
    static Stack<String> stack = new Stack<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String inputS;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            makeVps();
        }
        System.out.print(sb);
        br.close();
    }

    static void makeVps() throws Exception {
        inputS=br.readLine();

        for(int i=0;i<inputS.length();i++){
            vpsChar=inputS.charAt(i);

            if (vpsChar=='('){
                stack.push("(");
            }
            else if (vpsChar==')') {
                if (stack.isEmpty()) {
                    sb.append("NO").append("\n");
                    return;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty())
            sb.append("NO").append("\n");
        else
            sb.append("YES").append("\n");

        stack.clear();
        return;
    }

}
