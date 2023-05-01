package 브루트스포스;
import java.io.*;
import java.util.*;
public class BOJ_2309ver2 {
    static int arr[];
    static boolean isused[];
    
    static boolean find;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Vector<Integer> v=new Vector<>();
        Vector<Integer> finalV=new Vector<>();

        arr=new int[9];
        isused=new boolean [9];

        for(int i=0;i<9;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        isSevenPeople(0,0, v, finalV);
        br.close();

    }
    static void isSevenPeople(int r, int idx, Vector<Integer> v, Vector <Integer> finalV){
        if(r==7){
            int S=0;
            for(int i:v) S+=i;
            if(S==100) {
                Collections.sort(v);
                for(int i:v){
                    System.out.println(i);
                }
            }
            return;
        }
        for(int i=idx;i<9;i++){
            if(!isused[i]){
                isused[i]=true;
                v.add(arr[i]);
                isSevenPeople(r+1, idx+1, v, finalV);
                isused[i]=false;
                v.remove(Integer.valueOf(arr[i]));
            }
        }
    }

}
