import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] info = br.readLine().split(" ");
			int h = Integer.parseInt(info[0]);
			int w = Integer.parseInt(info[1]);
			int num = Integer.parseInt(info[2]) - 1;
			int floor = (num % h) + 1;
			int room = (num / h) + 1;

			bw.write(floor + (room < 10 ? "0" : "") + room);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}