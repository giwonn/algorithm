import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer nTokenizer = new StringTokenizer(br.readLine());
		StringTokenizer numsTokenizer = new StringTokenizer(br.readLine());
		StringTokenizer vTokenizer = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(nTokenizer.nextToken());
		String V = vTokenizer.nextToken();

		int count = 0;

		for (int i = 0; i < N; i++) {
			if (numsTokenizer.nextToken().equals(V)) {
				count += 1;
			}
		}

		System.out.println(count);
	}
}