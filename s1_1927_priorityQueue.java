import java.util.*;
import java.io.*;

public class s1_1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int inp = Integer.parseInt(br.readLine());
            if (inp == 0) {
                if (priq.size() == 0) {
                    bw.write(String.valueOf(0));
                } else {
                    bw.write(String.valueOf(priq.poll()));
                }
                bw.newLine();
            } else {
                priq.add(inp);
            }
        }
        bw.flush();
        bw.close();
    }
}