package simul;
import java.io.*;
import java.util.*;

import simul.BOJ_5212.Pair;
public class BOJ_2578 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Map<Integer, Pair> map = new HashMap<>();
	public static StringTokenizer st;
	public static int row[], col[], cLR, cRL, count, bingoNum;
	public static boolean flag;
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map.put(Integer.parseInt(st.nextToken()), new Pair(i,j));
			}
		}
		
		row = new int [5];
		col = new int [5];
		arr = new int [5][5];
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				int find = arr[i][j];
				count++;
				int x = map.get(find).x;
				int y = map.get(find).y;
				
				if(x == y) {
					cLR++;
				}
				if(x+y == 4) {
					cRL++;
				}
				
				row[x]++;
				col[y]++;
				
				if(row[x] == 5) bingoNum++;
				if(col[y] == 5) bingoNum++;
				if(cLR == 5) {
					bingoNum++;
					cLR = -1;
				}
				if(cRL == 5 ) {
					bingoNum++;
					cRL = -1;
				}
				
//				System.out.println("find: "+find+", x: "+x+", row[x]: "+row[x]+
//						", y: "+y +", col[y] : "+col[y]+", cLR : "+cLR+", cRL: "+cRL);
				
				if(bingoNum >= 3) {
					System.out.println(count);
					return;
				}
				
				
				
				
			}
		}
	}

}
