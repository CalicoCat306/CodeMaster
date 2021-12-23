import java.util.*;
import java.io.*;

public class s1_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> lis = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (lis.size() == 0) {
                    bw.write(String.valueOf(0));
                } else {
                    bw.write(String.valueOf(find(lis)));
                }
                bw.newLine();
            } else {

            }
        }
    }

    public static int find(List<Integer> lis) {
        int min = Integer.MAX_VALUE;
        for (Integer i : lis) {
            min = Math.max(min, i);
        }
        return min;
    }
}