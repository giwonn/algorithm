import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, String> map = new HashMap<>();
		map.put("12345678", "ascending");
		map.put("87654321", "descending");

		System.out.println(
				map.getOrDefault(
						br.readLine().replaceAll("\\s", ""),
						"mixed"
				)
		);
	}
}