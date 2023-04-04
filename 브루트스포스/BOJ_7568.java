package 브루트스포스;

import java.util.*;
import java.io.*;

/*
 * 1. 정렬을 이용해서, [덩치가 가장 큰 사람, 비슷한 사람, 덩치가 가장 작은 사람]으로 분류하고자 하였다.
 *  Arrays.sort(arr, new Comparator<int[]>() { // new Comparator 함수 Override
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] <= o2[0] && o1[1]>o2[1]) { 
                첫번째 원소값이 비교배열의 첫번째 원소값보다 작거나 같고,
                두번째 원소값이 비교 배열의 두번째 원소값보다 크다면
                    
                    o1[2]++;
                    o2[2]++;
                    세번째 원소값을 증가시켜서 해당 수만큼 나중에 순위를 정하려고 하였다.
                    키와 몸무게를 비교할 수 없는 경우, 배열의 중앙에 위치시킨다.
                return 0;

                } else if(o1[0]<o2[0] && o1[1]<o2[1]){ 
                키와 몸무게 모두 작은 경우, 배열의 마지막에 위치시킨다.
                 return -1;
                }else return 1; 
                키와 몸무게가 모두 비교 배열보다 큰 경우, 배열의 맨 앞에 위치시킨다.
            }
        });
 * 2. 
 */
public class BOJ_7568 {
    static int arr[][];
    //키와 몸무게를 받는 2차원 배열변수

    static int n;
    //사람 수를 받는 변수

    static int rank;
    //사람마다 순위를 정할 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] ss = s.split("\\s");
            arr[i][0] = Integer.parseInt(ss[0]);
            arr[i][1] = Integer.parseInt(ss[1]);
        }

        for (int i = 0; i < n; i++) {
            rank = 1;
            //모든 사람을 순회하면서(배열에 저장된 값 순회) 
            //랭크를 1로 초기화시키고, 자신보다 키와 몸무게가 큰 사람이 존재한다면
            //랭크를 1씩 크게 증가시키며, 마지막 사람까지 조회한다.

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                //자기 자신과 비교할 이유는 없으므로 다음 순회를 간다.

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            bw.append(rank + " ");
            bw.close();
            br.close();
        }
    }
}
