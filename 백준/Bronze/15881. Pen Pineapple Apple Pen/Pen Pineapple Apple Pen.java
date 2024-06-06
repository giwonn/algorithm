import java.io.*;
import java.util.regex.*;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();
        
        Pattern pattern = Pattern.compile("pPAp");
        Matcher matcher = pattern.matcher(str);
        
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        
        System.out.println(count);
	}
}
 