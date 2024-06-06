import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
        final int PAGE = 4;
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(str);

		int count = 0;
		while (matcher.find()) {
			int opCodeIndex = matcher.start() + count; // 명령코드의 위치는 이전에 추가한 NOP의 갯수에 영향을 받는다.

			int difference = opCodeIndex % PAGE;
			if (difference == 0) continue; // 명령코드의 인덱스가 4의 배수일 경우에는 스킵

            count += PAGE - difference;
		}

		System.out.println(count);
	}
}
