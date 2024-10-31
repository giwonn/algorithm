import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(
				Arrays.stream(br.readLine().split(""))
				.map(str -> str.charAt(0) > 'Z' ? str.toUpperCase() : str.toLowerCase())
				.collect(Collectors.joining(""))
		);

		bw.flush();
		bw.close();
	}
}