import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		String strB = br.readLine();
		int B = Integer.parseInt(strB);
		int C = Integer.parseInt(br.readLine());

		System.out.println(A + B - C);
		System.out.println(A * (int) Math.pow(10, strB.length()) + B  - C);
	}
}