import java.util.*;

class Solution {
	public static String[] solution(String[] records) {
		Map<String, String> nickname = getUserNickname(records);

		List<String> answer = new ArrayList<>();
		for (String record: records) {
			String[] arr = record.split(" ");
			if (arr[0].equals("Change")) continue;

			String message = arr[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
			answer.add(nickname.get(arr[1]) + message);
		}

		return answer.toArray(new String[0]);
	}

	public static Map<String, String> getUserNickname(String[] records) {
		Map<String, String> userNickname = new HashMap<>();

		for (String record: records) {
			String[] arr = record.split(" ");
			if (arr[0].equals("Leave")) continue;
			userNickname.put(arr[1], arr[2]);
		}

		return userNickname;
	}
}