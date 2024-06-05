import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[100][100];

            int endPointX = 0;
            int endPointY = 0;

            for(int i=0;i<matrix.length;i++){
                String[] arr = br.readLine().split(" ");

                for(int j=0;j<arr.length;j++){
                    matrix[i][j] = Integer.parseInt(arr[j]);
                    if(matrix[i][j] == 2){
                        endPointX = i;
                        endPointY = j;
                    }
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(endPointX);
            queue.add(endPointY);


            int answer = 0;
            //위 : 0, 우 : 1, 좌 : 2
            while(!queue.isEmpty()){
                int x = queue.poll();
                int y = queue.poll();

                //양쪽에 길이 있는지 확인
                if(y+1 < matrix[0].length && matrix[x][y+1] == 1){
                    //오른쪾에 길이 있으니 오른쪽으로 쭉 이동
                    while(true){
                        y++;
                        if(matrix[x-1][y] == 1){
                            break;
                        }
                    }

                } else if(y-1 >= 0 && matrix[x][y-1] == 1){
                    while(true){
                        y--;

                        if(matrix[x-1][y] == 1){
                            break;
                        }
                    }
                }
                if(x == 0) {
                    answer = y;
                    break;
                }

                queue.add(x-1);
                queue.add(y);


            }

            System.out.println("#" + t + " " + answer);
        }
	}
}
