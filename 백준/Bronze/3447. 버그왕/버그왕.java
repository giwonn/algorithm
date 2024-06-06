import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();

		String line = "";
		while((line = br.readLine()) != null) {
			while (line.contains("BUG")) {
				line = line.replaceAll("BUG", "");
			}
			list.add(line);
		}

		System.out.println(String.join("\n", list));
	}
}
