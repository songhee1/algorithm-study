package BFS;
import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class BOJ_5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char arr[][];
    static boolean fireVisit[][];
    static boolean sanVisit[][];
    static int fireDist[][];
    static int sanDist[][];
    static int testcase;
    static int w,h;
    static Queue<Pair> fireQueue;
    static Queue<Pair> sanQueue;
    static int dirX[]={1,0,-1,0};
    static int dirY[]={0,1,0,-1};
    public static void main(String[] args) throws Exception{
        testcase = Integer.parseInt(br.readLine());
        while(testcase-- >0){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            fireQueue = new LinkedList<>();
            sanQueue = new LinkedList<>();

            arr = new char [h][w];

            fireVisit = new boolean [h][w];
            sanVisit = new boolean[h][w];

            fireDist = new int [h][w];
            sanDist = new int [h][w];

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    fireDist[i][j]=-1;
                }
            }

            for(int i=0;i<h;i++){
                String miro = br.readLine();
                for(int j=0;j<w;j++){
                    arr[i][j] = miro.charAt(j);
                    if(arr[i][j] == '*' && fireVisit[i][j] == false){
                        fireQueue.add(new Pair(i,j));
                        fireDist[i][j]=0;
                        fireVisit[i][j]=true;
                    }else if(arr[i][j] == '@' && sanVisit[i][j] ==false ){
                        sanQueue.add(new Pair(i,j));
                        sanDist[i][j]=0;
                        sanVisit[i][j]=true;
                    }
                }
            }



            firebfs();
           
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(fireDist[i][j] == -1){
                        fireDist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            int a = sanbfs();

            if(a==-1){
                sb.append("IMPOSSIBLE").append("\n");
            }else{
                sb.append(a).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void firebfs(){
        while(!fireQueue.isEmpty()){
            Pair pair = fireQueue.poll();

            for(int i=0;i<dirX.length;i++){
                int nx = pair.x + dirX[i];
                int ny = pair.y + dirY[i];

                if(nx<0 || nx>=h || ny<0 || ny>=w) continue;

                if(fireVisit[nx][ny] == false && arr[nx][ny] != '#'){
                    fireVisit[nx][ny] = true;
                    fireDist[nx][ny] = fireDist[pair.x][pair.y]+1;
                    fireQueue.add(new Pair(nx, ny));
                }
            }
        }
    }

    static int sanbfs(){
        while(!sanQueue.isEmpty()){
            Pair pair = sanQueue.poll();

            for(int i=0;i<dirX.length;i++){
                int nx = pair.x + dirX[i];
                int ny = pair.y + dirY[i];

                if(nx<0 || nx>=h || ny<0 || ny>=w){
                    return  sanDist[pair.x][pair.y]+1;
                }
                if(sanVisit[nx][ny] == false && arr[nx][ny] != '#' && arr[nx][ny] != '*' && (sanDist[pair.x][pair.y]+1<fireDist[nx][ny])){
                    sanVisit[nx][ny] = true;
                    sanDist[nx][ny] = sanDist[pair.x][pair.y]+1;
                    sanQueue.add(new Pair(nx, ny));
                }
            }
        }

        return -1;
    }
}
