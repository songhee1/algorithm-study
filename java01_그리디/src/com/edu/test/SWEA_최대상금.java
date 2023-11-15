package com.edu.test;
import java.io.*;
import java.util.*;
public class SWEA_최대상금 {

	public static boolean visit[];
    public static int maxNum, count, idx, plus[], userCount;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();
            
            plus = new int[2];
            
            int n = Integer.parseInt(st.nextToken());
            int gop = 1;
            int namu = 1;
            while(n != 0) {
            	gop = n/10;
            	namu = n%10;
            	
            	n = gop;
            	list.add(0, namu);
            }
            visit = new boolean[list.size()];
            
            count = Integer.parseInt(st.nextToken());
            
            find(list, 0);
            
            sb.append("#"+test_case).append(" ").append(maxNum).append("\n");
            maxNum = 0;

		}
        System.out.println(sb);
	}
    
    public static void find(List<Integer> list, int idx){
    	if(idx == 2 && userCount < count){
        	int sum = 0;
            int a = plus[0];
            int b = plus[1];
            int aNum = list.get(a);
            int bNum = list.get(b);
            list.set(a, bNum);
            list.set(b, aNum);
            
            int gop = 1;
            for(int i=list.size()-1;i>=0;i--){
            	sum += list.get(i)*gop;
                gop *= 10;
            }
            
            maxNum = Math.max(a, maxNum);
            userCount++;
            return;
        }
        
        for(int i=0;i<list.size();i++){
        	if(!visit[i]){
            	visit[i] = true;
                plus[idx] = i;
                find(list, idx+1);
                visit[i] = false;
            }
        }
    }

}
