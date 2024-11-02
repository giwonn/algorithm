import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (String input = br.readLine(); !input.equals("0 0 0"); input = br.readLine()) {
			int[] triangle = Arrays.stream(input.split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
			bw.write(Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2], 2) ? "right" : "wrong");
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
