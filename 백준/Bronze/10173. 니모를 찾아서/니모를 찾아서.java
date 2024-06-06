import java.io.*;
import java.util.regex.*;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile("(?i)(nemo)");

		String str = "";
		while ((str = br.readLine()) != null) {
            if (str.equals("EOI")) break;
			Matcher matcher = pattern.matcher(str);
			System.out.println(matcher.find() ? "Found" : "Missing");
		}
	}
}
 