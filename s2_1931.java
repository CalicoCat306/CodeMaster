import java.util.*;
import java.io.*;

public class s2_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!hm.containsKey(start)) {
                hm.put(start, end);
            } else {
                hm.put(start, Math.min(hm.get(start), end));
            }
        }

        int[][] table = new int[hm.size()][2];
        int cnt = 0;
        for (Integer i : hm.keySet()) {
            table[cnt][0] = i;
            table[cnt][1] = hm.get(i);
            cnt++;
        }
        Arrays.sort(table);

        int pick = 0;
        int ptr = 0;
        int count = 0;

        while (true) {
            if (table[pick][1] <= table[ptr][0]) {
                break;
            } else if (table[pick][1] > table[ptr][1]) {
                pick = ptr;
            }
        }

    }
}