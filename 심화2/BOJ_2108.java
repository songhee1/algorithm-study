package 심화2;
import java.io.*;
import java.util.*;
public class BOJ_2108 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,sum;
    static int arr[], frequency[];
    static int maxFrequency;
    public static void main(String[] args) throws Exception{
        n=Integer.parseInt(br.readLine());

        Vector <Integer> v= new Vector<>();

        arr=new int[n]; //입력값을 저장하는 배열
        frequency=new int[8001]; //값에 대한 빈도수를 저장하는 배열

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        Arrays.sort(arr);
        
        // 산술 평균 출력
        sb.append(Math.round((double)sum/n)).append("\n").append(arr[n/2]).append("\n");
        
        for(int i:arr){
            frequency[i+4000]++;
            //빈도수 증가
            maxFrequency=Math.max(maxFrequency, frequency[i+4000]);
            //가장 큰 빈도수 찾기
        }

        for(int i=0;i<frequency.length;i++){
            if(maxFrequency==frequency[i]){
                //가장 큰 빈도수가 같다면
                v.add(i-4000);
                //벡터에 추가
            }
        }

        if(v.size()==1) sb.append(v.get(0)).append("\n");
        //벡터에 요소가 하나라면 하나만 출력
        else {
            sb.append(v.get(1)).append("\n");
            //여러개 라면 그 중 두번째 출력
        }

        sb.append(arr[n-1]-arr[0]).append("\n");


        System.out.print(sb);
        br.close();
        

    }
}
