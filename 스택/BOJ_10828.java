package 스택;
import java.io.*;
import java.util.*;
public class BOJ_10828 {
    static int n;
    static String order;
    static int num;
    static Stack<Integer> stack=new Stack<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());

            order=st.nextToken();

            if(order.equals("push"))  num=Integer.parseInt(st.nextToken());

            orderSelect(order, num);
        }
        System.out.print(sb);
        br.close();
    }
    static void orderSelect(String order, int num){
        switch(order){
            case "push":
            stack.push(num);
            break;

            case "top":
            if(stack.isEmpty()) sb.append(-1).append("\n");
            else sb.append(stack.peek()).append("\n");
            break;

            case "size":
            sb.append(stack.size()).append("\n");
            break;

            case "empty":
            if(stack.isEmpty()) sb.append(1).append("\n");
            else sb.append(0).append("\n");
            break;

            case "pop":
            if(stack.isEmpty()) sb.append(-1).append("\n");
            else sb.append(stack.pop()).append("\n");
            break;
        }
    }
}
