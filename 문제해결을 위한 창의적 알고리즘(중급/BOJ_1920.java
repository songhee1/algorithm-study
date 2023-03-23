import java.io.*;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringBuilder sb=new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];

        String line = br.readLine();
        String[] string = line.split("\\s");

        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(string[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];

        String line2 = br.readLine();
        String[] string2 = line2.split("\\s");

        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(string2[i]);
            int anw = 0;
            for (int j = 0; j < N; j++) {
                if (mArr[i] == nArr[j]) {
                    anw = 1;
                    break;
                }
            }
            bw.write(Integer.toString(anw));
            bw.write("\n");
            // sb.append("anw").append("\n");
        }
        br.close();
        bw.close();

    }
}
