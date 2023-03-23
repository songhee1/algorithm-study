import java.io.BufferedReader;
import java.io.*;

public class lowerbound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        long []arr=new long[1000000];
        String []string=s.split("\\s");
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(string[i]);
        }
        int k=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            if(k<=arr[i]){
                System.out.println(i+1);
                br.close();
                return;
            }
        }
        System.out.println(n+1);
        br.close();
        return;
        
    }
}
