import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = br.readLine().trim();
		System.out.println(answer.isEmpty() ? 0 : answer.split(" ").length);
	}
}
