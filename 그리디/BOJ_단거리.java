import java.io.IOException;
import java.util.*;

public class Main {
    static class Road{
        int start;
        int end;
        int dist;
        Road(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        ArrayList<Shortcut> path = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            if (end > D)
                continue;
            if (end - start > dist)
                path.add(new Road(start, end, dist));
        }

        Collections.sort(path, new Comparator<Road>() {
            public int compare(Road o1, Road o2) {
                if (o1.start == o2.start){
                    return Integer.compare(o1.end, o2.end);
                }  
                return Integer.compare(o1.start, o2.start);
            }
        });

        int[] d = new int[D+1];
        int move = 0;
        int idx = 0;
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        while (move < D){
            if (idx < path.size()){
                Road s = path.get(idx);
                if (move == s.start){
                    d[s.end] = Math.min(d[move] + s.dist, d[s.end]);
                    idx++;
                } else {
                  d[move + 1] = Math.min(d[move + 1], d[move] + 1);
                  move++;
                }
            } else {
                d[move + 1] = Math.min(d[move + 1], d[move] + 1);
                move++;
            }
        }
        System.out.println(d[D]);

    }
}
