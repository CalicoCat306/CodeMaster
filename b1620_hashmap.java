import java.util.*;
import java.io.*;

public class b1620_hashmap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hm = new HashMap<>();
		String[] ary = new String[n + 1];

		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			hm.put(name, i + 1);
			ary[i + 1] = name;
		}

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if (temp.charAt(0) < 58) {
				bw.write(ary[Integer.parseInt(temp)]);
				bw.newLine();
			} else {
				bw.write(String.valueOf(hm.get(temp)));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}
}