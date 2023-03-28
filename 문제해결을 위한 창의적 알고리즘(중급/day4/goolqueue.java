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

public class goolqueue {
    static int n;
    static int graph[][];
    static boolean visited[][];
    static int nums[];
    static int num, nSum;
    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int nx, ny;
    static Queue<Pair> q=new LinkedList<>();
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        graph=new int[n][n];
        visited=new boolean[n][n];
        Vector <Integer> v=new Vector<>();

        for(int i=0;i<n;i++){
            String s=br.readLine();
            String []ss=s.split("\\s");
            for(int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(ss[j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1 && visited[i][j]==false){
                    visited[i][j]=true;
                    nSum++;
                    q.add(new Pair(i,j));
                    num=0;
                    v.add(BFS());
                }
            }
        }

        bw.append(nSum+"\n");
        Collections.sort(v, new Comp());
        for(Integer a: v){
            bw.append(a+"\n");
        }
        bw.close();
        br.close();
    
    }
    static int BFS(){
        while(!q.isEmpty()){
            num++;
            Pair cur=q.poll();
            for(int dir=0;dir<4;dir++){
                nx=cur.x+dx[dir];
                ny=cur.y+dy[dir];
                if(RangeCorrect()&& visited[nx][ny]==false && graph[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        return num;
        
    }
    static boolean RangeCorrect(){
        if(nx<0 || nx>=n||ny<0||ny>=n) return false;
        return true;
    }
}
