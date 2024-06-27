static int N,M,H, MIN = 4;
static boolean[][] game;
public static void main(String[] args) throws Exception {
   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer(in.readLine());
   N = Integer.parseInt(st.nextToken());//세로선
   M = Integer.parseInt(st.nextToken());//가로선
   H = Integer.parseInt(st.nextToken());//세로선마다 가로선을 놓을 수 있는 위치 개수
 
   game = new boolean[H+1][N+1];
   for(int i=0;i<M;i++){
      st = new StringTokenizer(in.readLine());
      game[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
   }
 
   //첫번째 가지치기
   int cnt=0, tmp;
   for(int i=1;i<=N;i++){
      tmp = 0;
      for(int j=1;j<=H;j++){
         if(game[j][i]) tmp++;
      }
      if(tmp%2!=0) cnt++;
   }
   if(cnt>3){
      System.out.println(-1);
      return;
   }
 
   plus(0,1,1);
   if(MIN!=4) System.out.println(MIN);
   else System.out.println(-1);
 
}
