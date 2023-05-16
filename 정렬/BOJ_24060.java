package 정렬;
import java.io.*;
import java.util.*;

public class BOJ_24060 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int arr[];
 
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length-1);

    }

    static void merge_sort(int arr[], int p, int r){
       int q=0;
        if(arr[p]<arr[r]){
            q = (p+r)/2;
            merge_sort(arr, p, q);
            merge_sort(arr, q+1, r);
            merge(arr, p, q,r);
        }
    }

    static void merge(int arr[], int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = 1;
        int tmp[] = new int [1000000];

        while(i<=q && j<=r){
            if(arr[i]<=arr[j]){
                tmp[t++] = arr[i++];
                tmp[t] = arr[i];
                t++;
                i++;
            }else{
                tmp[t++] = arr[j++];
                tmp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i<=q){
            tmp[t++] = arr[i++];
        }
        while(j<=r){
            tmp[t++] = arr[j++];
        }

        i = p;
        t = 1;

        while(i<=r){
            arr[i++] = tmp[t++];
        }
    }
}
