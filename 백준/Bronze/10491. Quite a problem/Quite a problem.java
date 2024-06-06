import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile("(?i)(p)roblem");

		String str = "";
		while ((str = br.readLine()) != null) {
			Matcher matcher = pattern.matcher(str);
			System.out.println(matcher.find() ? "yes" : "no");
		}
	}
}
