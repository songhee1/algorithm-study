import java.io.*;
import java.util.*;

public class BOJ_24060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, count;
    static int arr[], sorted[];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sorted = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);

        if(count < k){
            System.out.println(-1);
        }
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) { 
            //반복해주기
            if (arr[l] <= arr[r]) {
                count++;
                sorted[idx] = arr[l];
                if (count == k)
                    System.out.println(sorted[idx]);
                idx++;
                l++;

            } else {
                count++;
                sorted[idx] = arr[r];
                if (count == k)
                    System.out.println(sorted[idx]);
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                count++;
                sorted[idx] = arr[r];
                if (count == k)
                    System.out.println(sorted[idx]);
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                count++;
                sorted[idx] = arr[l];
                if (count == k)
                    System.out.println(sorted[idx]);
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
