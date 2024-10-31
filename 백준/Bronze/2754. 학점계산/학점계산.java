import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] grade = br.readLine().split("");
		float score = getScore(grade[0]);

		if (grade.length > 1) {
			switch (grade[1]) {
				case "+":
					score += 0.3;
					break;
				case "-":
					score -= 0.3;
					break;
				default:
					break;
			}
		}

		System.out.println(score);
	}

	public static int getScore(String grade) {
		if (grade.equals("A")) {
			return 4;
		} else if (grade.equals("B")) {
			return 3;
		} else if (grade.equals("C")) {
			return 2;
		} else if (grade.equals("D")) {
			return 1;
		}

		return 0;
	}
}