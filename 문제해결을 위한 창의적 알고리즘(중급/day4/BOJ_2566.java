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
public class BOJ_2566 {
    
    static int graph[][];
    static int maxNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Vector<Pair> v = new Vector<>();

        graph=new int [9][9];
        for(int i=0;i<9;i++){
            String s=br.readLine();
            String []ss=s.split("\\s");
            for(int j=0;j<9;j++){
                graph[i][j]=Integer.parseInt(ss[j]);
                if(v.size()>0){
                    Pair x=v.firstElement();
                    if(graph[x.x][x.y]<graph[i][j]){
                        v.clear();
                        v.add(new Pair(i,j));
                    }
                }else{
                    v.add(new Pair(i,j));
                }
            }
        }

        Pair cur=v.firstElement();
        bw.append(graph[cur.x][cur.y]+"\n");
        bw.append((cur.x+1)+" "+(cur.y+1));
        bw.close();
        br.close();
    }
}
