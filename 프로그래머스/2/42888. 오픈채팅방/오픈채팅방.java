import java.util.*;

class Solution {
	public static String[] solution(String[] records) {
		List<String> answer = new ArrayList<>();
		Map<String, String> userNicknames = getUserNicknames(records);

		for (String record: records) {
			if (record.startsWith("Change")) continue;
			String[] arr = record.split(" ");
			answer.add(userNicknames.get(arr[1]) + (arr[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다."));
		}

		return answer.toArray(new String[0]);
	}

	public static Map<String, String> getUserNicknames(String[] records) {
		Map<String, String> userNickname = new HashMap<>();

		for (String record: records) {
			if (record.startsWith("Leave")) continue;
			String[] arr = record.split(" ");
			userNickname.put(arr[1], arr[2]);
		}

		return userNickname;
	}
}
