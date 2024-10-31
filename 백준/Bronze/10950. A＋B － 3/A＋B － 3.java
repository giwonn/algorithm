import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st1.nextToken());
			int B = Integer.parseInt(st1.nextToken());

			System.out.println(A + B);
		}
	}
}