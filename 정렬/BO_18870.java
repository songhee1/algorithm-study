package 정렬;
import java.util.*;
import java.io.*;
public class BO_18870{
    static int n;
    static int arr[][];
    /*정렬
     * -10 
     */
    public static void main(String []args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        arr=new int[n][2];

        String s=br.readLine();
        st=new StringTokenizer(s);
        for(int i=0;i<n;i++){
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=0;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][0]==arr[j][0]) continue;
                if(arr[i][0]>arr[j][0])
                    arr[i][1]++;
                
            }
        }

        for(int i=0;i<n;i++)
         sb.append(arr[i][1]+" "
        
    }
}