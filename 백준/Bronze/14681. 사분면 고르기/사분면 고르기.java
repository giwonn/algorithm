import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st2.nextToken());

		if (x > 0 && y > 0) {
			System.out.println(1);
		} else if (x < 0 && y > 0) {
			System.out.println(2);
		} else if (x < 0 && y < 0) {
			System.out.println(3);
		} else if (x > 0 && y < 0){
			System.out.println(4);
		}
	}
}