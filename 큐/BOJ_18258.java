package 큐;
import java.io.*;
import java.util.*;
public class BOJ_18258 {
    static int n;
    static String order;
    static int num;
    static int arr[];
    static int pointer=0;
    static int backPointer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(br.readLine());
        arr=new int[2000001];

        for(int i=0;i<n;i++){
            String s=br.readLine();
            st=new StringTokenizer(s);
            order=st.nextToken();
            if(order.equals("push")) {
                arr[pointer]=Integer.parseInt(st.nextToken());
                pointer++;
            }
            switch(order){
                case "pop":
                if(pointer-backPointer==0) sb.append(-1).append("\n");
                else {
                    sb.append(arr[backPointer]).append("\n");
                    backPointer++;
                }
                break;
                
                case "front":
                if(pointer-backPointer==0) sb.append(-1).append("\n");
                else {
                    sb.append(arr[backPointer]).append("\n");
                }
                break;

                case "back":
                if(pointer-backPointer==0) sb.append(-1).append("\n");
                else {
                    sb.append(arr[pointer-1]).append("\n");
                }
                break;

                case "size":
                sb.append(pointer-backPointer).append("\n");
                break;

                case "empty":
                if(pointer-backPointer==0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;


            }
        }

        System.out.print(sb);
        br.close();
    }
}
