import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Comp implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        return o1>o2?-1:(o1==o2?0:1);
    }
}

class gool{
    static int n;
    static int graph[][];
    static boolean visited[][];
    static int nums[];
    static int num, nSum;
    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};
    static int nx, ny;
   
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
                    DFS(i,j);
                    v.add(num);
                    num=0;
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
    static void DFS(int i, int j){
        num++;
        for(int dir=0;dir<4;dir++){
            nx=i+dx[dir];
            ny=j+dy[dir];
            if(RangeCorrect()&& visited[nx][ny]==false && graph[nx][ny]==1){
                visited[nx][ny]=true;
                DFS(nx,ny);
            }
        }
    }
    static boolean RangeCorrect(){
        if(nx<0 || nx>=n||ny<0||ny>=n) return false;
        return true;
    }

}