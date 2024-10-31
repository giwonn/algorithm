import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] answers = new boolean[30];

		for (int i = 0;  i < 28; i++) {
			answers[Integer.parseInt(br.readLine()) - 1] = true;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 30; i++) {
			if (!answers[i]) {
				bw.write(String.valueOf(i+1));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}
}