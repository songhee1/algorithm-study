import java.util.*;
import java.io.*;
class Solution{
	static class Student{
		int k;
		double sum;
		String score;
		Student(int k, double sum){
			this.k = k;
			this.sum = sum;		
		}
	}
	static List<Student> list;
	static List<String> sc = new ArrayList<>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken()); //학생 수
			int k = Integer.parseInt(st.nextToken()); //학점을 알고 싶은 학생의 번호
			
			list = new LinkedList<>();
			String s = "A+ A0 A- B+ B0 B- C+ C0 C- D0";
			st = new StringTokenizer(s, " ");
			for(int i=0;i<10;i++) {
				sc.add(st.nextToken());
			}
			
			Student kStudent;
			for(int i=0;i<n;i++) {
				String input = br.readLine();
				
				st = new StringTokenizer(input, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Student(i+1, a*0.35+b*0.45+c*0.2));
				
				if(i+1 == k) {
					kStudent =new Student(i+1,a*0.35+b*0.45+c*0.2);
				}
			}
			
			Collections.sort(list, (o1, o2)->{
				if(o2.sum>o1.sum) return 1;
				else if(o2.sum == o1.sum) return 0;
				else return -1;
			});
			
			int ab = n/10;
			int idx = 0;
			
			for(int i=0;i<10;i++) {
				for(int j=0;j<ab;j++) {
					list.get(idx).score = sc.get(i);
					idx++;
				}
			}
			
			for(int i=0;i<n;i++) {
			    System.out.println("총점 : "+list.get(i).sum+", 학점 : "+list.get(i).score);
			}
			
			for(int i=0;i<n;i++) {
				if(list.get(i).k == k) {
					sb.append("#"+test_case+" ").append(list.get(i).score).append("\n");
					break;
				}
			}
			
		}
		
		System.out.println(sb);
	}
}
