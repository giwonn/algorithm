import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();
			if (line == null) break;

			StringTokenizer st = new StringTokenizer(line);

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			System.out.println(A + B);
		}
	}
}