import java.io.*;
import java.util.*;

public class BOJ_10994{
    static StringBuilder sb =  new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, size;
    static char arr[][];
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        size = 4*(n-1)+1;
        arr = new char [size][size];
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arr[i][j]=' ';
            }
        }

        star(0,size);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    static void star(int start, int size){
        if(size <=1){
            arr[start][start]='*';
            return;
        }
        
        for(int i=start;i<size;i++){
            arr[start][i]='*'; //맨 윗줄 가로
            arr[size-1][i]='*';//맨 아랫줄 가로
            arr[i][start]='*';
            arr[i][size-1]='*';
        }

        star(start+2,size-2);
    }
}