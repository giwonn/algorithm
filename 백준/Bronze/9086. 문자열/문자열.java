import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] chars = br.readLine().toCharArray();

			bw.write(chars[0]);
			bw.write(chars[chars.length - 1]);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}